package com.samir.safetynet.dto;

import lombok.Data;

import java.util.List;

@Data
public class Address {
    private String street;
    private String zip;
    private String city;
    private List<Integer> fireStationIds;
}