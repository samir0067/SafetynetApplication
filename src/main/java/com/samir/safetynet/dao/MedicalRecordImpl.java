package com.samir.safetynet.dao;

import com.samir.safetynet.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordImpl implements MedicalRecordDao {
    public static List<MedicalRecord> medicalRecords = new ArrayList<>();

    @Override
    public MedicalRecord findById(long medicalRecord) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getId() == medicalRecord) return record;
        }
        return null;
    }

    @Override
    public MedicalRecord findByFirstNameAndLastName(String firstName, String lastName) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getPersonId().getFirstName().equals(firstName) && medicalRecord.getPersonId().getLastName().equals(lastName)) {
                return medicalRecord;
            }
        }
        return null;
    }

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecords;
    }

    @Override
    public MedicalRecord update(String firstName, String lastName) {
        return null;
    }

    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) {
        return null;
    }

    @Override
    public void delete(long medicalRecord) {

    }
}
