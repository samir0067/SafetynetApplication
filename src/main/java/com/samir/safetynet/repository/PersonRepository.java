package com.samir.safetynet.repository;

import com.samir.safetynet.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Override
    Optional<Person> findById(Long id);
}
