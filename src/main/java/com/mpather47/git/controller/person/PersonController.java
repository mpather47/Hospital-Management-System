package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.impl.PersonServiceImpl;
import com.mpather47.git.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class    PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        boolean personExist = false;
        Person newPerson = PersonFactory.createPerson(person.getName(), person.getDateOfBirth());
        if(newPerson !=null){
            personExist = true;
        }

        if(personExist){
            return personService.create(newPerson);
        }

        else return PersonFactory.createPerson("","");
    }

    @GetMapping("/read/{id}")
    public Person read(@PathVariable String id){
        boolean personExist = false;
        if(id !=null){
            personExist = true;
        }

        if(personExist = true){
            return personService.read(id);
        }
        else return null;
    }

    @PostMapping("/update")
    public Person update(@RequestBody Person person){
        boolean personExist = false;
        if(person !=null) {
            personExist = true;
        }

        if(personExist){
            return personService.update(person);
        }
        else return null;

    }

    @GetMapping("/all")
    public Set<Person> getAll(){
        return personService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean personExist = false;
        if(id != null){
            personExist = true;
        }

        if(personExist){
            return personService.delete(id);

        }
        else return false;
    }
}
