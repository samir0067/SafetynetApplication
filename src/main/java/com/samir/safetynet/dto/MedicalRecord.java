
package com.samir.safetynet.dto;

import java.util.List;

import lombok.Data;

@Data
public class MedicalRecord {
    private List<String> medications;
    private List<String> allergies;
}
