package com.samir.safetynet.dao;

import com.samir.safetynet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao {

    Person findById(long person);

    Person findByFirstNameAndLastName(String firstName, String lastName);

    Person update(String firstName, String lastName);

    List<Person> findAll();

    Person save(Person person);

    void deleteInfoAPerson(String firstName, String lastName);

}
