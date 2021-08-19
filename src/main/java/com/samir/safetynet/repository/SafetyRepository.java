package com.samir.safetynet.repository;

import com.jsoniter.JsonIterator;
import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@Component
public class SafetyRepository {

    private List<Person> persons;
    private List<MedicalRecord> medicalrecords;
    private List<FireStation> firestations;

    private static SafetyRepository safetyRepository;

    public static void init() throws IOException {
        if (safetyRepository == null) {
            File file = ResourceUtils.getFile("classpath:data.json");
            String content = Files.readString(file.toPath());
            safetyRepository = JsonIterator.deserialize(content, SafetyRepository.class);
        }
    }

    public static SafetyRepository getSafetyRepository() {
        return safetyRepository;
    }

}
