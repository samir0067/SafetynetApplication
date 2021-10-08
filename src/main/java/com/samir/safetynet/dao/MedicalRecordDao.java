package com.samir.safetynet.dao;

import com.samir.safetynet.dto.Person;
import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordDao {

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
