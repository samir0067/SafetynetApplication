package com.samir.safetynet.repository;

import com.jsoniter.JsonIterator;
import com.samir.safetynet.dto.FireStation;
import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class SafetyRepository {

    private List<Person> persons;
    private List<MedicalRecord> medicalRecords;
    private List<FireStation> fireStations;

    private static SafetyRepository safetyRepository;

    public static void init() throws IOException {
        if (safetyRepository == null) {
            File file = new File(Objects.requireNonNull(SafetyRepository.class.getResource("data.json")).getFile());
            String content = Files.readString(file.toPath());
            safetyRepository = JsonIterator.deserialize(content, SafetyRepository.class);
        }
    }

    public static SafetyRepository getSafetyRepository() {
        return safetyRepository;
    }

//    @EventListener
//    public void eventListener(ApplicationStartedEvent event) throws IOException {
//        log.info("Application started");
//        init();
//    }

}
