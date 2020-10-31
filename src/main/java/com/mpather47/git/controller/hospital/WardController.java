package com.mpather47.git.controller.hospital;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.services.hospital.impl.WardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ward")
public class WardController {

    @Autowired
    private WardServiceImpl service;

    @PostMapping("/create")
    public Ward create(@RequestBody Ward ward){
        return service.create(ward);
    }

    @GetMapping("/read/{id}")
    public Ward read(@PathVariable Integer id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Ward update(@RequestBody Ward ward){
        return service.update(ward);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @GetMapping("/all")
    public Set<Ward> getAll(){
        return service.getAll();
    }

}
