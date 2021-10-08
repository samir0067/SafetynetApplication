package com.samir.safetynet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalRecordWithPerson {
  private Person person;
  private MedicalRecord medicalRecord;
}