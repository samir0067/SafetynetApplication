package com.samir.safetynet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalRecord {
    private List<String> medications;
    private List<String> allergies;
}