package com.example.hibernate.controller;

import com.example.hibernate.Persons;
import com.example.hibernate.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return service.getPersonsByCity(city);
    }
}
