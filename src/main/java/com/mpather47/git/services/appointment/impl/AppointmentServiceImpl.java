package com.mpather47.git.services.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.repository.appointment.AppointmentRepository;
import com.mpather47.git.services.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    private static AppointmentService service = null;

    @Autowired
    private AppointmentRepository repository;

    public AppointmentServiceImpl() {
    }

    public static AppointmentService getService() {
        if (service == null)
            service = new AppointmentServiceImpl();
        return service;
    }

    @Override
    public List<Appointment> getAll() {
        return repository.findAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Appointment read(String s) {
        Optional<Appointment> appointmentOptional = repository.findById(s);
        return appointmentOptional.orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public boolean delete(String s) {
        if(read(s)!=null){
            repository.deleteById(s);
            return true;
        }
        return false;
    }
}
