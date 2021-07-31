package com.samir.safetynet.dao;

import com.samir.safetynet.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordDao {

    MedicalRecord findById(long medicalRecord);

    MedicalRecord findByFirstNameAndLastName(String firstName, String lastName);

    MedicalRecord update(String firstName, String lastName);

    List<MedicalRecord> findAll();

    MedicalRecord save(MedicalRecord medicalRecord);

    void delete(long medicalRecord);
}
