package com.telran.java4h5hjpa6transactional.repository;

import com.telran.java4h5hjpa6transactional.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
