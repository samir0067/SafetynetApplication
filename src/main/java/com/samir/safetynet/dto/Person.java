
package com.samir.safetynet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String email;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String phone;
    private Address address;
    private MedicalRecord medicalRecord;
}
