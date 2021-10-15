package com.samir.safetynet.controller;

import com.samir.safetynet.dao.FireStationDao;
import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.dto.Person;
import com.samir.safetynet.dto.PersonsWithStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  private FireStationDao fireStationDao;

  private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

  @GetMapping("/firestation")
  public ResponseEntity<?> getFireStations(@RequestParam(required = false) Integer stationNumber) {
    LocalDate currentDate = LocalDate.now();
    List<Person> persons;
    AtomicInteger countAdults = new AtomicInteger();
    AtomicInteger countChildren = new AtomicInteger();
    if (stationNumber == null) {
      List<FireStation> fireStations = fireStationDao.getFirStations();
      return new ResponseEntity<>(fireStations, HttpStatus.OK);
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
    return new ResponseEntity<>(personsWithStatistics, HttpStatus.OK);
  }
}
