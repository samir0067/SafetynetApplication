package com.samir.safetynet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonsWithStatistics {
    private int countChildren;
    private int countAdults;
    private List<Person> persons;
}