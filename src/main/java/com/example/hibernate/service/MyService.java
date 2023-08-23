package com.example.hibernate.service;

import com.example.hibernate.Persons;
import com.example.hibernate.repository.MyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    private MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
