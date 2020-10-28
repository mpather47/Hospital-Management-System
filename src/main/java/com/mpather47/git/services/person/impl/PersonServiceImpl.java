package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.person.ContactRepository;
import com.mpather47.git.repository.person.PersonRepository;
import com.mpather47.git.services.person.ContactService;
import com.mpather47.git.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl  implements PersonService{
    @Autowired
    private PersonRepository repository;

    @Override
    public Set getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Person create(Person person) {
        return this.repository.save(person);
    }

    @Override
    public Person read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Person update(Person person) {
        if(this.repository.existsById(person.getPersonId())){
            return this.repository.save(person);
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
