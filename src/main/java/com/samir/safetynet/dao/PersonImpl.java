package com.samir.safetynet.dao;

import com.samir.safetynet.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonImpl implements PersonDao {
    public static List<Person> personList = new ArrayList<>();

    @Override
    public Person findById(long person) {
        for (Person person1 : personList) {
            if (person1.getId() == person) return person1;
        }
        return null;
    }

    @Override
    public Person findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Person update(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void deletePerson(String firstName, String lastName) {

    }
}
