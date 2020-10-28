package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.person.ContactRepository;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.person.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository repository;

    @Override
    public Set getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Contact update(Contact contact) {
        if(this.repository.existsById(contact.getContactId())){
            return this.repository.save(contact);
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
