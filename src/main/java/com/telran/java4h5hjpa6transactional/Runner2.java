package com.telran.java4h5hjpa6transactional;

import com.telran.java4h5hjpa6transactional.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

//@Component
public class Runner2 implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Person person = Person.builder()
                .lastName("Stone")
                .firstName("Peter")
                .build();
        entityManager.persist(person);
    }
}
