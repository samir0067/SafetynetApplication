package com.samir.safetynet.entity;

import lombok.Data;

import java.util.List;

@Data
public class MedicalRecord {

    private Person firstName;
    private Person lastName;
    private Person birthdate;
    private List<String> medications;
    private List<String> allergies;
}