package com.samir.safetynet.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    private long id;
    private Person personId;
    private List<String> medications;
    private List<String> allergies;
}