package com.samir.safetynet.dto;

import lombok.Data;

@Data
public class Address {
    private String address;
    private String zip;
    private String city;
    private int fireStationId;
}