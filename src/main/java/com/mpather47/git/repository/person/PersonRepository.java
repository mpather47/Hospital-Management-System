package com.mpather47.git.repository.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person, String>{
    
}
