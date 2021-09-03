package com.samir.safetynet.repository;

import com.jsoniter.JsonIterator;
import com.samir.safetynet.entity.FireStationEntity;
import com.samir.safetynet.entity.MedicalRecordEntity;
import com.samir.safetynet.entity.PersonEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@Data
public class SafetyGrossRepository {

    private List<PersonEntity> persons;
    private List<FireStationEntity> firestations;
    private List<MedicalRecordEntity> medicalrecords;

    private static SafetyGrossRepository safetyGrossRepository;

    public static void init() throws IOException {
        if (safetyGrossRepository == null) {
            File file = ResourceUtils.getFile("classpath:data.json");
            String content = Files.readString(file.toPath());
            safetyGrossRepository = JsonIterator.deserialize(content, SafetyGrossRepository.class);
            RepositoryMapper.mapTo(safetyGrossRepository);
        }
    }

    public static SafetyGrossRepository getSafetyGrossRepository() {
        return safetyGrossRepository;
    }
}

