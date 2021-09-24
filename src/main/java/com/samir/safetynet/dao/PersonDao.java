package com.samir.safetynet.dao;

import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.Person;
import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class PersonDao {

    public List<Person> getPersons() {
        return SafetyRepository.getSafetyRepository().getPersons();
    }

    public Person addPerson(Person person) {
        List<Person> persons = SafetyRepository.getSafetyRepository().getPersons();
        Person maxElement = persons.stream().max(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        }).get();
        person.setId(maxElement.getId() + 1);
        SafetyRepository.getSafetyRepository().getPersons().add(person);
        return person;

    }

    public void deletePersonByFirstNameAndLastName(String firstName, String lastName) {
        SafetyRepository.getSafetyRepository().getPersons()
                .removeIf(element ->
                        Objects.equals(element.getFirstName(), firstName) &&
                                Objects.equals(element.getLastName(), lastName));
    }

    public Person putPerson(Person person) {
        Person foundPerson = SafetyRepository.getSafetyRepository().getPersons()
                .stream().filter(element -> element.getId() == person.getId())
                .findFirst().get();
        person.setId(foundPerson.getId());
        SafetyRepository.getSafetyRepository().getPersons()
                .removeIf(element -> element.getId() == person.getId());
        SafetyRepository.getSafetyRepository().getPersons().add(person);
        return person;
    }

    public Person resetMedicalRecord(String id) {
        Person foundPerson = SafetyRepository.getSafetyRepository().getPersons()
                .stream().filter(
                        element -> (element.getFirstName().concat(element.getLastName())).equals(id)
                )
                .findFirst().get();
        foundPerson.setMedicalRecord(new MedicalRecord());
        SafetyRepository.getSafetyRepository().getPersons()
                .removeIf(element -> element.getId() == foundPerson.getId());
        SafetyRepository.getSafetyRepository().getPersons().add(foundPerson);
        return foundPerson;
    }

}
