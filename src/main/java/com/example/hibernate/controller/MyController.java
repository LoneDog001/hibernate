package com.example.hibernate.controller;

import com.example.hibernate.model.Persons;
import com.example.hibernate.repository.MyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class MyController {
    private MyRepository myRepository;

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public List<Persons> findByCityIgnoreCase(@RequestParam String city) {
        return myRepository.findByCityIgnoreCase(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Persons> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return myRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Persons> findByNameIgnoreCaseAndSurnameIgnoreCase(@RequestParam String name, @RequestParam String surname) {
        return myRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
    }

    @PostAuthorize("#username == authentication.principal.username")
    public String hi(@RequestParam ("username") String username){
        return username;
    }
}
