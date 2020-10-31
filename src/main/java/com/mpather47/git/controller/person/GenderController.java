package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.services.person.impl.GenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderServiceImpl service;

    @PostMapping("/create")
    public Gender create(@RequestBody Gender gender){
        return service.create(gender);
    }

    @GetMapping("/read/{id}")
    public Gender read(@PathVariable Integer id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Gender update(@RequestBody Gender g){
        return service.update(g);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @GetMapping("/all")
    public Set<Gender> getAll(){
        return service.getAll();
    }

}
