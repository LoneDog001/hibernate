package com.example.hibernate.repository;

import com.example.hibernate.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<Persons, Integer> {

    List<Persons> findByCityIgnoreCase(String city);

    List<Persons> findByAgeLessThanOrderByAge(int age);

    Optional<Persons> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
}

