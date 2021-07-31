package com.samir.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private FireStation fireStationId;
    private String phone;
    private String email;
    private String birthdate;
    private MedicalRecord medicalRecordId;
}