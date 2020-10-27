package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.services.person.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public Set getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Address update(Address address) {
        if(this.repository.existsById(address.getAddressId())){
            return this.repository.save(address);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {

         this.repository.deleteById(s);
        if(this.repository.existsById(s)){
            return false;
        }else{
            return true;
        }
    }
}
