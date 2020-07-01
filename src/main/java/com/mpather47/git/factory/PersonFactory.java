package com.mpather47.git.factory;

import com.mpather47.git.entity.Person;

public class PersonFactory {
    public static Person createPerson(int personId, String name,String dob){
        return new Person.Builder().setPersonId(personId).setName(name).setDateOfBirth(dob).build();
    }
}
