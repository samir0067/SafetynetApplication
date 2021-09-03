package com.samir.safetynet.dto;

import lombok.Data;

@Data
public class Person {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String phone;
    private Address address;
    private MedicalRecord medicalRecord;
}