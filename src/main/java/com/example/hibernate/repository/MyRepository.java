package com.example.hibernate.repository;

import com.example.hibernate.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Persons p where p.city = :city");
        query.setParameter("city", city);
        return (List<Persons>) query.getResultList();
    }
}
