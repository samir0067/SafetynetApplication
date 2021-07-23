package com.samir.safetynet.model;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private FireStation fireStationId;
    private String phone;
    private String email;
    private Date birthdate;
    private MedicalRecord medicalRecordId;
}