package com.samir.safetynet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
  private String street;
  private String zip;
  private String city;
  private List<Integer> fireStationIds;
}