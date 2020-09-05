package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.person.PersonRepository;
import com.mpather47.git.repository.person.impl.AddressRepositoryImpl;
import com.mpather47.git.repository.person.impl.PersonRepositoryImpl;
import com.mpather47.git.services.person.AddressService;

import java.util.HashSet;
import java.util.Set;

public class AddressServiceImpl implements AddressService {

    private static AddressService service=null;
    private AddressRepository repository;

    private AddressServiceImpl() {
        this.repository = AddressRepositoryImpl.getRepository();
    }

    public static AddressService getService(){
        if(service==null) service = new AddressServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
