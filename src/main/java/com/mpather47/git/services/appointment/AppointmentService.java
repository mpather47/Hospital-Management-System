package com.mpather47.git.services.appointment;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface AppointmentService extends IService<Appointment, String> {
    Set<Appointment> getAll();
}
