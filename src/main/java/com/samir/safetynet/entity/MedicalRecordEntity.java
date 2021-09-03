package com.samir.safetynet.entity;

import lombok.Data;

import java.util.List;

@Data
public class MedicalRecordEntity {

    private String firstName;
    private String lastName;
    private String birthdate;
    private List<String> medications;
    private List<String> allergies;
}