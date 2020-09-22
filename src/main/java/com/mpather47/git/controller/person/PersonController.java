package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.impl.PersonServiceImpl;
import com.mpather47.git.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        Person newPerson = PersonFactory.createPerson(person.getName(), person.getDateOfBirth());
        return personService.create(newPerson);
    }

    @GetMapping("/read{id}")
    public Person read(@PathVariable String id){
        return personService.read(id);
    }

    @PostMapping("/update")
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }
    @GetMapping("/all")
    public Set<Person> getAll(){
        return personService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return personService.delete(id);
    }
}
