package com.telran.java4h5hjpa6transactional;

import com.telran.java4h5hjpa6transactional.entity.Person;
import com.telran.java4h5hjpa6transactional.repository.PersonAddressRepository;
import com.telran.java4h5hjpa6transactional.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

//@Component
public class Runner4 implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final PersonAddressRepository personAddressRepository;

    @Autowired
    public Runner4(PersonRepository personRepository, PersonAddressRepository personAddressRepository) {
        this.personRepository = personRepository;
        this.personAddressRepository = personAddressRepository;
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //Entity Life Cycle

        //1. Transient - new
        Person person = Person.builder()
                .firstName("abc")
                .lastName("xyz")
                .build();

        personRepository.save(person); //first name = abc
        //2. Managed - there is such record in the database
        //- find
        //- save

        person.setFirstName("John");

        //3. Removed - помечаем, что объект БУДЕТ удален!
        personRepository.delete(person);




        //@Transactional
        //outer transaction begin

        //update


        //@Transactional(propagation = Propagation.REQUIRES_NEW)
        //nested transaction begin
        //      insert
        //      exception
        //      update
        //nested transaction close


        //outer transaction close
















    }
    //update person first name
    //flush() - слить все изменения в базу данных
    //close transaction
}
