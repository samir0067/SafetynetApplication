package com.samir.safetynet.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private String phone;
    private String email;


    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}