package com.example.homeworkOne.service;

import com.example.homeworkOne.entity.Address;
import com.example.homeworkOne.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getAddress(Long id) {
        Address findAddress = new Address();
        if (this.addressRepository.findById(id).isPresent()) {
            findAddress = this.addressRepository.findById(id).get();
        }
        return findAddress;
    }

    public Address addAddress(Address address) {
        Address newAddress = new Address();

        newAddress.setCountry(address.getCountry());
        newAddress.setCity(address.getCity());
        newAddress.setStreet(address.getStreet());
        newAddress.setStreetNumber(address.getStreetNumber());
      //  newAddress.setUser(address.getUser());

        return this.addressRepository.save(newAddress);
    }


    public void deleteAddress(Long id) {
        this.addressRepository.deleteById(id);
    }
}