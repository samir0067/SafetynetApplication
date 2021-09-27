package com.samir.safetynet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String phone;
    private int age;
    private Address address;
    private MedicalRecord medicalRecord;
}