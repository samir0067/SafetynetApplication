package com.samir.safetynet.controller;

import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.Person;
import com.samir.safetynet.dto.PersonsWithStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class FireStationController {

    @Autowired
    private PersonDao personDao;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @GetMapping("/firestation")
    public PersonsWithStatistics getFireStations(@RequestParam(required = false) Integer stationNumber) {
        LocalDate currentDate = LocalDate.now();
        List<Person> persons;
        AtomicInteger countAdults = new AtomicInteger();
        AtomicInteger countChildren = new AtomicInteger();
        if (stationNumber == null) {
            persons = personDao.getPersons();
        } else {
            persons = personDao.getPersons()
                    .stream()
                    .filter(element -> element.getAddress().getFireStationIds().contains(stationNumber))
                    .collect(Collectors.toList());
            persons.forEach(element -> {
                int age = Period.between(LocalDate.parse(element.getBirthdate(), dtf), currentDate).getYears();
                element.setAge(age);
                if (age < 18) {
                    countChildren.getAndIncrement();
                } else {
                    countAdults.getAndIncrement();
                }
            });
        }
        PersonsWithStatistics personsWithStatistics = new PersonsWithStatistics();
        personsWithStatistics.setPersons(persons);
        personsWithStatistics.setCountChildren(countChildren.get());
        personsWithStatistics.setCountAdults(countAdults.get());
        return personsWithStatistics;
    }

    @GetMapping("/childAlert")
    public List<Person> getChildAlert(@RequestParam String address) {
        LocalDate currentDate = LocalDate.now();
        List<Person> persons = personDao.getPersons()
                .stream()
                .filter(element -> {
                    String birthdate = element.getBirthdate();
                    int years = Period.between(LocalDate.parse(birthdate, dtf), currentDate).getYears();
                    return (element.getAddress().getStreet().equals(address) && (years < 18));
                })
                .collect(Collectors.toList());
        persons.forEach(element -> element.setAge(Period.between(LocalDate.parse(element.getBirthdate(), dtf), currentDate).getYears()));
        System.out.println(persons.size());
        return persons;
    }

    @GetMapping("/phoneAlert")
    public List<String> getPhoneAlert(@RequestParam Integer firestation) {
        return personDao.getPersons().stream()
                .filter(element -> element.getAddress().getFireStationIds().contains(firestation))
                .map(Person::getPhone).collect(Collectors.toList());
    }

    @GetMapping("/fire")
    public List<Person> getFireStationByAddress(@RequestParam String address) {
        LocalDate currentDate = LocalDate.now();
        List<Person> persons = personDao.getPersons()
                .stream()
                .filter(element -> address.equals(element.getAddress().getStreet()))
                .collect(Collectors.toList());
        persons.forEach(element -> element.setAge(Period.between(LocalDate.parse(element.getBirthdate(), dtf), currentDate).getYears()));
        System.out.println(persons.size());
        return persons;
    }

    @GetMapping("/flood/stations")
    public List<Person> getFloodStations(@RequestParam List<Integer> stations) {
        LocalDate currentDate = LocalDate.now();
        List<Person> persons = personDao.getPersons().stream()
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
        persons.forEach(element -> element.setAge(Period.between(LocalDate.parse(element.getBirthdate(), dtf), currentDate).getYears()));
        System.out.println(persons.size());
        return persons;
    }

    @GetMapping("/personInfo")
    public List<Person> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        LocalDate currentDate = LocalDate.now();
        List<Person> persons = personDao.getPersons()
                .stream()
                .filter(element -> (firstName.equals(element.getFirstName()) && lastName.equals(element.getLastName())))
                .collect(Collectors.toList());
        persons.forEach(element -> element.setAge(Period.between(LocalDate.parse(element.getBirthdate(), dtf), currentDate).getYears()));
        return persons;
    }

    @GetMapping("/communityEmail")
    public List<String> getCommunityEmail(@RequestParam String city) {
        return personDao.getPersons().stream()
                .filter(element -> city.equals(element.getAddress().getCity()))
                .map(Person::getEmail).collect(Collectors.toList());
    }
}
