package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.utility.Helper;

public class PersonFactory {

    public static Person createPerson( String name, String dob){
        String personId = Helper.generateId();
        return new Person.Builder().setPersonId(personId).setName(name).setDateOfBirth(dob).build();
    }
}
