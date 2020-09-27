package com.mpather47.git.controller.employee;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.employee.PositionFactory;
import com.mpather47.git.services.employee.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/position")

public class PositionController {
    @Autowired


    private PositionServiceImpl positionService;

    @PostMapping("/create")
    public Position create(@RequestBody Position position) {

        Position newPosition = PositionFactory.createPosition(position.getPositionCode(), position.getPositionStatus());

        return positionService.create(newPosition);
    }


    @GetMapping("/read/{id}")
    public Position read(@PathVariable String id) {
        return positionService.read(id);
    }
    @PostMapping("/update")
    public Position update(@RequestBody Position position){
        return positionService.update(position);
    }
    @GetMapping("/all")
    public Set<Position> getall() {
        return positionService.getAll();

    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return positionService.delete(id);
    }


}