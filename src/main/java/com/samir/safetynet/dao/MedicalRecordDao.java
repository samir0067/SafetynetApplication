package com.samir.safetynet.dao;

import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.MedicalRecordWithPerson;
import com.samir.safetynet.dto.Person;
import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MedicalRecordDao {

  @Autowired
  private PersonDao personDao;

  public MedicalRecord addMedicalRecord(MedicalRecordWithPerson medicalRecordWithPerson) {
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


  public MedicalRecord putMedicalRecord(MedicalRecordWithPerson medicalRecordWithPerson) {
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

  public Person deleteMedicalRecordByFirstNameAndLastName(String id) {
    Person foundPerson = SafetyRepository.getSafetyRepository().getPersons()
        .stream()
        .filter(element -> (element.getFirstName().concat(element.getLastName())).equals(id))
        .findFirst()
        .orElseThrow();
    foundPerson.setMedicalRecord(null);
    SafetyRepository.getSafetyRepository().getPersons()
        .removeIf(element -> element.getId() == foundPerson.getId());
    SafetyRepository.getSafetyRepository().getPersons().add(foundPerson);
    return foundPerson;
  }
}
