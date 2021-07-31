package com.samir.safetynet.repository;

import com.samir.safetynet.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {

    @Override
    Optional<MedicalRecord> findById(Long id);
}
