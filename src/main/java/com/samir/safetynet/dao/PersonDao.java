package com.samir.safetynet.dao;

import com.samir.safetynet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao {

    List<Person> findAll();

    Person findById(long person);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    Person save(Person person);

    Person update(String firstName, String lastName);

    void deletePerson(String firstName, String lastName);

}
