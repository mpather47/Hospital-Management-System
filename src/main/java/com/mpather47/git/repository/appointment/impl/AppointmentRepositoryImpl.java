package com.mpather47.git.repository.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.repository.appointment.AppointmentRepository;
import java.util.HashSet;
import java.util.Set;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    private Set<Appointment> appointments;
    private static AppointmentRepository appointmentRepository = null;

    public AppointmentRepositoryImpl() {
        this.appointments = new HashSet<>();
    }

    public static AppointmentRepository getAppointmentRepository(){
        if (appointmentRepository == null)
            appointmentRepository = new AppointmentRepositoryImpl();
        return appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment){
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment read(final String appointmentId){
        return appointments.stream().filter(appointment -> appointment.getAppointmentId().equals(appointmentId)).
                findAny().orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment){
        Appointment oldAppointment = read(appointment.getAppointmentId());
        if (oldAppointment != null){
            appointments.remove(oldAppointment);
            appointments.add(appointment);
        }
        return appointment;
    }

    @Override
    public boolean delete(String appointmentId){
        boolean deleted = false;
        Appointment oldAppointment = read(appointmentId);
        if (oldAppointment != null) {
            appointments.remove(oldAppointment);
            deleted = true;
        }
        return deleted;
    }

    @Override
    public Set<Appointment> getAll() {
        return appointments;
    }

}
