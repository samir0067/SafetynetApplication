package com.samir.safetynet.controller;

import com.samir.safetynet.dao.FireStationDao;
import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FireStationController {

    @Autowired
    private FireStationDao fireStationDao;

    @Autowired
    private PersonDao personDao;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @GetMapping("/firestation")
    public List<Person> getFireStations(@RequestParam(required = false) Integer stationNumber) {
        return (stationNumber == null) ?
                personDao.getPersons() :
                personDao.getPersons().stream()
                        .filter(element -> element.getAddress().getFireStationIds().contains(stationNumber))
                        .collect(Collectors.toList());
    }

    @GetMapping("/childAlert")
    public List<Person> getChildAlert(@RequestParam String address) {
        LocalDate currentDate = LocalDate.now();
        return personDao.getPersons().stream()
                .filter(element -> {
                    String birthdate = element.getBirthdate();
                    int years = Period.between(LocalDate.parse(birthdate, dtf), currentDate).getYears();
                    return (element.getAddress().getStreet().equals(address) && (years < 18));
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/phoneAlert")
    public List<String> getPhoneAlert(@RequestParam Integer firestation) {
        return personDao.getPersons().stream()
                .filter(element -> element.getAddress().getFireStationIds().contains(firestation))
                .map(element -> element.getPhone()).collect(Collectors.toList());
    }

    @GetMapping("/fire")
    public List<Person> getFireStationByAddress(@RequestParam String address) {
        return personDao.getPersons().stream()
                .filter(element -> address.equals(element.getAddress().getStreet()))
                .collect(Collectors.toList());
    }

    @GetMapping("/flood/stations")
    public List<Person> getFloodStations(@RequestParam List<Integer> stations) {
        return personDao.getPersons().stream()
                .filter(element -> {
                    boolean found = false;
                    for (Integer station : stations) {
                        if (element.getAddress().getFireStationIds().contains(station)) {
                            found = true;
                            break;
                        }
                    }
                    return found;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/personInfo")
    public List<Person> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        return personDao.getPersons().stream()
                .filter(element -> (firstName.equals(element.getFirstName()) && lastName.equals(element.getLastName())))
                .collect(Collectors.toList());
    }

    @GetMapping("/communityEmail")
    public List<String> getCommunityEmail(@RequestParam String city) {
        return personDao.getPersons().stream()
                .filter(element -> city.equals(element.getAddress().getCity()))
                .map(element -> element.getEmail()).collect(Collectors.toList());
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return personDao.addPerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestBody Person person) {
        personDao.deletePerson(person);
    }

    @PutMapping("/person")
    public Person putPerson(@RequestBody Person person) {
        return personDao.putPerson(person);
    }
}
