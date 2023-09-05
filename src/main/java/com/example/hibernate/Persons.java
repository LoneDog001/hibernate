package com.example.hibernate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;

@Entity
@Table(name = "persons")
@Builder
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    @Min(value = 0, message = "Не может быть отрицательным")
    @Max(value = 120, message = "Редко кто доживает")
    private int age;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phoneNumber;


    public Persons() {
    }

    public Persons(Integer id, String name, String surname, int age, String city, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
}


