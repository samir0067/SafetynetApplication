package com.samir.safetynet.controller;

import com.samir.safetynet.dao.MedicalRecordDao;
import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.MedicalRecordWithPerson;
import com.samir.safetynet.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

  @Autowired
  private PersonDao personDao;

  @Autowired
  private MedicalRecordDao medicalRecordDao;

  @GetMapping
  public List<MedicalRecord> getMedicalRecords() {
    return personDao.getPersons()
        .stream()
        .map(Person::getMedicalRecord)
        .collect(Collectors.toList());
  }

  @PostMapping
  public MedicalRecord addMedicalRecord(@RequestBody MedicalRecordWithPerson medicalRecordWithPerson) {
    return medicalRecordDao.addMedicalRecord(medicalRecordWithPerson);
  }

  @PutMapping
  public MedicalRecord putMedicalRecord(@RequestBody MedicalRecordWithPerson medicalRecordWithPerson) {
    return medicalRecordDao.putMedicalRecord(medicalRecordWithPerson);
  }

  @DeleteMapping("/{id}")
  public Person deleteMedicalRecord(@PathVariable String id) {
    return medicalRecordDao.deleteMedicalRecordByFirstNameAndLastName(id);
  }
}

