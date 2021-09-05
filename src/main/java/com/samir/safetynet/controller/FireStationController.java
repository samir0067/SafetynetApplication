package com.samir.safetynet.controller;

import com.samir.safetynet.dao.FireStationDao;
import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/firestation")
    public List<Person> getFireStations(@RequestParam(required = false) Integer stationNumber) {
        return (stationNumber == null) ?
                personDao.getPersons() :
                personDao.getPersons().stream()
                        .filter(element -> element.getAddress().getFireStationIds().contains(stationNumber))
                        .collect(Collectors.toList());
    }

    @GetMapping("childAlert")
    public List<Person> getChildAlert(@RequestParam String address) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return personDao.getPersons().stream()
                .filter(element -> {
                    String birthdate = element.getBirthdate();
                    int years = Period.between(LocalDate.parse(birthdate, dtf), currentDate).getYears();
                    return (element.getAddress().getStreet().equals(address) && (years < 18));
                })
                .collect(Collectors.toList());
    }

    @GetMapping("phoneAlert")
    public List<String> getPhoneAlert(@RequestParam Integer firestation) {
        return personDao.getPersons().stream()
                .filter(element -> element.getAddress().getFireStationIds().contains(firestation))
                .map(Person::getPhone).collect(Collectors.toList());
    }
}
