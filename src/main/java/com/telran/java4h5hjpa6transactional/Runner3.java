package com.telran.java4h5hjpa6transactional;

import com.telran.java4h5hjpa6transactional.entity.Person;
import com.telran.java4h5hjpa6transactional.entity.PersonAddress;
import com.telran.java4h5hjpa6transactional.repository.PersonAddressRepository;
import com.telran.java4h5hjpa6transactional.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
public class Runner3 implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final PersonAddressRepository personAddressRepository;

    @Autowired
    public Runner3(PersonRepository personRepository, PersonAddressRepository personAddressRepository) {
        this.personRepository = personRepository;
        this.personAddressRepository = personAddressRepository;
    }

    @Override
//    @Transactional
    public void run(String... args) throws Exception {
        PersonAddress a = PersonAddress.builder()
                .city("a")
                .street("a")
                .build();

        personAddressRepository.save(a);

        Person person = Person.builder()
                .firstName("abc")
                .lastName("abc")
                .personAddress(a)
                .build();

        personRepository.save(person);


        Person p = personRepository.findById(1L).get();
        //on lazy - no person addresses
        //on eager - should get person addresses, when getting person by id

        System.out.println(p);

        //Fetch Policy
        //- lazy (default)
        //- eager
    }
}
