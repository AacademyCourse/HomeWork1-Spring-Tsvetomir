package com.example.homeworkOne.runner;

import com.example.homeworkOne.entity.Address;
import com.example.homeworkOne.entity.User;
import com.example.homeworkOne.repository.AddressRepository;
import com.example.homeworkOne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        createUser();
        createAddress();
    }

    private void createUser() {

        User user1 = new User();
        user1.setFirstName("Ivan");
        user1.setLastName("Petrov");
        user1.setEmail("ivan@gmail.com");
        user1.setPhoneNumber("082938293");
        user1.setCreatedAt(Instant.now());


        User user2 = new User();
        user2.setFirstName("Petkan");
        user2.setLastName("Petkanov");
        user2.setEmail("petran@gmail.com");
        user1.setPhoneNumber("03228373");
        user2.setCreatedAt(Instant.now());

        userRepository.saveAll(List.of(user1,user2));
    }
    private void createAddress() {

        Address address1 = new Address();
        address1.setCountry("Bulgaria");
        address1.setCity("Varna");
        address1.setStreet("Madara 28");
        address1.setStreetNumber(409);


        Address address2 = new Address();
        address2.setCountry("Romania");
        address2.setCity("Constanta");
        address2.setStreet("Geto 55");
        address2.setStreetNumber(169);

        addressRepository.saveAll(List.of(address1,address2));

    }

}
