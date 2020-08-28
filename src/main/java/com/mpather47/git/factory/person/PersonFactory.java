package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Person;

public class PersonFactory {
    public static Person createPerson(String personId, String name, String dob){
        return new Person.Builder().setPersonId(personId).setName(name).setDateOfBirth(dob).build();
    }
}
