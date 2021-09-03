package com.samir.safetynet.entity;

import lombok.Data;

@Data
public class PersonEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
}