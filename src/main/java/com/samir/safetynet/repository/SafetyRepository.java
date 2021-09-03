package com.samir.safetynet.repository;


import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.dto.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class SafetyRepository {

    private List<Person> persons;
    private List<FireStation> firestations;
    private static SafetyRepository safetyRepository;

    public static SafetyRepository getSafetyRepository() {
        return safetyRepository;
    }

    public static void setSafetyRepository(SafetyRepository safetyRepository) {
        SafetyRepository.safetyRepository = safetyRepository;
    }
}

