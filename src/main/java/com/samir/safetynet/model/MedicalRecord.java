package com.samir.safetynet.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class MedicalRecord {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String birthdate;
    @Embedded
    private String[] medications;
    @Embedded
    private String[] allergies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}