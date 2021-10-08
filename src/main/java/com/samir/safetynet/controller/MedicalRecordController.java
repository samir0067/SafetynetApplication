package com.samir.safetynet.controller;

import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.MedicalRecordWithPerson;
import com.samir.safetynet.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

  @Autowired
  private PersonDao personDao;


  @GetMapping
  public List<MedicalRecord> getMedicalRecords() {
    return personDao.getPersons()
        .stream()
        .map(Person::getMedicalRecord)
        .collect(Collectors.toList());
  }

  @PostMapping
  public MedicalRecord addMedicalRecord(@RequestBody MedicalRecordWithPerson medicalRecordWithPerson) {
    Optional<Person> optionalPerson = personDao.getPersons()
        .stream()
        .filter(element -> Objects.equals(element.getFirstName(), medicalRecordWithPerson.getPerson().getFirstName())
            && Objects.equals(element.getLastName(), medicalRecordWithPerson.getPerson().getLastName()))
        .findFirst();
    if (optionalPerson.isPresent()) {
      Person person = optionalPerson.get();
      person.setMedicalRecord(medicalRecordWithPerson.getMedicalRecord());
      personDao.putPerson(person);
      return person.getMedicalRecord();
    }
    return null;
  }

  @PutMapping
  public MedicalRecord putMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
    return null;
  }

  @DeleteMapping("/{id}")
  public Person deleteMedicalRecord(@PathVariable String id) {
    return null;
  }
}

