package com.example.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table
@Builder
public class Persons {

    @EmbeddedId
    private Contact contact;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phoneNumber;

    public Persons() {
    }

    public Persons(Contact contact, String city, String phoneNumber) {
        this.contact = contact;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
}
