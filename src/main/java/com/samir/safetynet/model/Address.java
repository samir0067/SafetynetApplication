package com.samir.safetynet.model;

import lombok.Data;

@Data
public class Address {
    private Long id;
    private String address;
    private String city;
    private String zip;
}