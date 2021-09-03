package com.samir.safetynet.repository;

import com.jsoniter.JsonIterator;
import com.samir.safetynet.entity.FireStation;
import com.samir.safetynet.entity.MedicalRecord;
import com.samir.safetynet.entity.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@Data
public class SafetyBareRepository {

    private List<Person> persons;
    private List<FireStation> firestations;
    private List<MedicalRecord> medicalrecords;

    private static SafetyBareRepository safetyBareRepository;

    public static void init() throws IOException {
        if (safetyBareRepository == null) {
            File file = ResourceUtils.getFile("classpath:data.json");
            String content = Files.readString(file.toPath());
            safetyBareRepository = JsonIterator.deserialize(content, SafetyBareRepository.class);
            System.out.println("ok");
        }
    }

    public static SafetyBareRepository getSafetyBareRepository() {
        return safetyBareRepository;
    }
}

