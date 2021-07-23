package com.samir.safetynet.model;

import lombok.Data;


@Data
public class FireStation {
    private Long id;
    private String station;
    private Address address;
}