package com.samir.safetynet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FireStation {
    private int id;
    private Address address;
}