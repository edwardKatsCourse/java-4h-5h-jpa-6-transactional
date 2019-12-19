package com.telran.java4h5hjpa6transactional;

import com.telran.java4h5hjpa6transactional.entity.Person;
import com.telran.java4h5hjpa6transactional.entity.PersonAddress;
import com.telran.java4h5hjpa6transactional.repository.PersonAddressRepository;
import com.telran.java4h5hjpa6transactional.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Runner implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final PersonAddressRepository personAddressRepository;

    @Autowired
    public Runner(PersonRepository personRepository, PersonAddressRepository personAddressRepository) {
        this.personRepository = personRepository;
        this.personAddressRepository = personAddressRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    //transaction open
    public void run(String... args) throws Exception {
        PersonAddress address_1 = PersonAddress.builder() //insert
                .city("Haifa")
                .street("Rotshild")
                .houseNumber("11")
                .build();

        PersonAddress address_2 = PersonAddress.builder() //insert
                .city("Haifa")
                .street("Haatsmaut")
                .houseNumber("1")
                .build();

        Person person = Person.builder() //insert into person values 'John', 'Smith',
                .firstName("John")
                .lastName("Smith")
                .personAddress(address_1) //FK -15
                .personAddress(address_2) //FK
                .build();

        //em.persist(person)
        //|person -> personAddress|

//        personAddressRepository.save(address_1);
//        personAddressRepository.save(address_2);

//        if (person.getFirstName().equals("John")) {
//            throw new RuntimeException("Хвватит нам Джонов в нашей базе данных!!!!");
//        }
        personRepository.save(person);

        person.setLastName("Abcdefg");


        //transaction open
//        Person p = personRepository.getOne(1L); //select * from person where id = 1;
        //transaction close


        //Person (PersonAddress)
//        p.getPersonAddresses(); //select * from person_address
//        System.out.println(p);
    } //transaction close
}
