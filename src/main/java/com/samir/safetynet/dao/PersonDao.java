package com.samir.safetynet.dao;

import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.dto.Person;
import com.samir.safetynet.repository.SafetyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDao {

    public List<Person> getPersons() {
        return SafetyRepository.getSafetyRepository().getPersons();
    }

}
