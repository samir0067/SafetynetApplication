package com.samir.safetynet.dao;

import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.Person;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static com.samir.safetynet.repository.SafetyRepository.getSafetyRepository;

@Service
public class PersonDao {

    private Person addMedicalRecord(Person person) {
        person.setMedicalRecord(new MedicalRecord());
        return updatePerson(person);
    }

    private Person updatePerson(Person person) {
        getSafetyRepository().getPersons().removeIf(element -> element.getId() == person.getId());
        getSafetyRepository().getPersons().add(person);
        return person;
    }

    public List<Person> getPersons() {
        return getSafetyRepository().getPersons();
    }

    public Person addPerson(Person person) {
        List<Person> persons = getSafetyRepository().getPersons();
        Person maxElement = persons.stream().max(Comparator.comparingInt(Person::getId)).get();
        person.setId(maxElement.getId() + 1);
        getSafetyRepository().getPersons().add(person);
        return person;

    }

    public Person putPerson(Person person) {
        return getSafetyRepository()
                .getPersons()
                .stream()
                .filter(element -> element.getId() == person.getId())
                .findFirst()
                .map(this::updatePerson)
                .orElseThrow();
    }

    public Person resetMedicalRecord(String id) {
        return getSafetyRepository()
                .getPersons()
                .stream()
                .filter(element -> (element.getFirstName().concat(element.getLastName())).equalsIgnoreCase(id))
                .findFirst()
                .map(this::addMedicalRecord)
                .orElseThrow();
    }

    public void deletePersonByFirstNameAndLastName(String firstName, String lastName) {
        getSafetyRepository().getPersons()
                .removeIf(element ->
                        Objects.equals(element.getFirstName(), firstName) &&
                                Objects.equals(element.getLastName(), lastName));
    }

}
