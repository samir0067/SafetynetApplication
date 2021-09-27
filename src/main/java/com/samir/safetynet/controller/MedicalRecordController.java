package com.samir.safetynet.controller;

import com.samir.safetynet.dao.MedicalRecordDao;
import com.samir.safetynet.dto.MedicalRecord;
import com.samir.safetynet.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordDao medicalRecordDao;

    @GetMapping("/")
    public List<MedicalRecord> getMedicalRecords() {
        return null;
    }

    @PostMapping
    public MedicalRecord addPerson(@RequestBody MedicalRecord medicalRecord) {
        return null;
    }

    @PutMapping
    public MedicalRecord putPerson(@RequestBody MedicalRecord medicalRecord) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Person deleteMedicalRecord(@PathVariable String id) {
        return medicalRecordDao.deleteMedicalRecordByFirstNameAndLastName(id);
    }
}

