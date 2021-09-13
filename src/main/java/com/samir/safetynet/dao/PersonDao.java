package com.samir.safetynet.dao;

import com.samir.safetynet.dto.Person;
import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

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

    public void deletePerson(Person person) {
        SafetyRepository.getSafetyRepository().getPersons()
                .removeIf(element -> element.getId() == person.getId());
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

}
