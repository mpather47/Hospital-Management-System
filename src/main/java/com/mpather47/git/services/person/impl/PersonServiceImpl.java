package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.person.ContactRepository;
import com.mpather47.git.repository.person.PersonRepository;
import com.mpather47.git.repository.person.impl.ContactRepositoryImpl;
import com.mpather47.git.repository.person.impl.PersonRepositoryImpl;
import com.mpather47.git.services.person.ContactService;
import com.mpather47.git.services.person.PersonService;

import java.util.Set;

public class PersonServiceImpl  implements PersonService{

    private static PersonService service=null;
    private PersonRepository repository;

    private PersonServiceImpl() {
        this.repository = PersonRepositoryImpl.getRepository();
    }

    public static PersonService getService(){
        if(service==null) service = new PersonServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Person create(Person person) {
        return this.repository.create(person);
    }

    @Override
    public Person read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Person update(Person person) {
        return this.repository.update(person);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
