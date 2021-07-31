package com.samir.safetynet.dao;

import com.samir.safetynet.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonImpl implements PersonDao {
    public static List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public Person findById(long person) {
        for (Person person1 : personList) {
            if (person1.getId() == person) return person1;
        }
        return null;
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName) {
        for (Person person : personList) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person save(Person person) {
        personList.add(person);
        return person;
    }

    @Override
    public Person update(String firstName, String lastName) {
        return null;
    }

    @Override
    public void deletePerson(String firstName, String lastName) {
        Person person = findByFirstNameAndLastName(firstName, lastName);
        personList.remove(person);
    }
}
