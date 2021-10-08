package com.samir.safetynet.controller;

import com.samir.safetynet.dao.PersonDao;
import com.samir.safetynet.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonDao personDao;

  @GetMapping
  public List<Person> getPersons() {
    return personDao.getPersons();
  }

  @PostMapping
  public Person addPerson(@RequestBody Person person) {
    return personDao.addPerson(person);
  }

  @PutMapping
  public Person putPerson(@RequestBody Person person) {
    return personDao.putPerson(person);
  }

  @DeleteMapping
  public void deletePersonByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
    personDao.deletePersonByFirstNameAndLastName(firstName, lastName);
  }
}

