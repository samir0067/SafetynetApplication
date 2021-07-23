package com.samir.safetynet.model;

import lombok.Data;


@Data
public class MedicalRecord {
    private Long id;
    private Person personId;
    private String[] medications;
    private String[] allergies;
}