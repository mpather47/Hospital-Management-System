package com.mpather47.git.repository.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface PersonRepository extends IRepository<Person, String> {
    Set<Person> getAll();
}
