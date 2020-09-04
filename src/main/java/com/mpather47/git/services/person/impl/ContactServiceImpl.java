package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.person.ContactRepository;
import com.mpather47.git.repository.person.impl.AddressRepositoryImpl;
import com.mpather47.git.repository.person.impl.ContactRepositoryImpl;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.person.ContactService;

import java.util.Set;

public class ContactServiceImpl implements ContactService{

    private static ContactService service=null;
    private ContactRepository repository;

    private ContactServiceImpl() {
        this.repository = ContactRepositoryImpl.getRepository();
    }

    public static ContactService getService(){
        if(service==null) service = new ContactServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.create(contact);
    }

    @Override
    public Contact read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.update(contact);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
