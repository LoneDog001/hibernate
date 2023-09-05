package com.example.hibernate.controller;

import com.example.hibernate.Persons;
import com.example.hibernate.repository.MyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class MyController {
    private MyRepository myRepository;

    @GetMapping("/by-city")
    public List<Persons> findByCityIgnoreCase(@RequestParam String city) {
        return myRepository.findByCityIgnoreCase(city);
    }

    @GetMapping("/by-age")
    public List<Persons> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return myRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Persons> findByNameIgnoreCaseAndSurnameIgnoreCase(@RequestParam String name, @RequestParam String surname) {
        return myRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
    }
}
