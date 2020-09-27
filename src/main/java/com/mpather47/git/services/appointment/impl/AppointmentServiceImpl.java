package com.mpather47.git.services.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.repository.appointment.AppointmentRepository;
import com.mpather47.git.repository.appointment.impl.AppointmentRepositoryImpl;
import com.mpather47.git.services.appointment.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static AppointmentService service = null;
    private AppointmentRepository repository;

    public AppointmentServiceImpl() {
        repository = AppointmentRepositoryImpl.getAppointmentRepository();
    }

    public static AppointmentService getService() {
        if (service == null)
            service = new AppointmentServiceImpl();
        return service;
    }

    @Override
    public Set<Appointment> getAll() {
        return repository.getAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.create(appointment);
    }

    @Override
    public Appointment read(String s) {
        return repository.read(s);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return repository.update(appointment);
    }

    @Override
    public boolean delete(String s) {
        return repository.delete(s);
    }
}
