package com.mpather47.git.controller.appointment;


import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.services.appointment.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl service;

    @PostMapping("/create")
    public Appointment create(@RequestBody Appointment appointment){
        return service.create(appointment);
    }

    @GetMapping("/read/{id}")
    public Appointment read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Appointment update(@RequestBody Appointment appointment){
        return service.update(appointment);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/all")
    public Set<Appointment> getAll(){
        return service.getAll();
    }

}
