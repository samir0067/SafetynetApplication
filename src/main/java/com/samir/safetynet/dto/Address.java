package com.samir.safetynet.dto;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String zip;
    private String city;
    private int fireStationId;
}