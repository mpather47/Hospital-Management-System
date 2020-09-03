package com.mpather47.git.services.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface PersonService extends IService<Person, String> {
    Set<Person> getAll();

    //unique business logic
}
