package com.mpather47.git.services.appointment;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.services.IService;

import java.util.List;
import java.util.Set;

public interface AppointmentService extends IService<Appointment, String> {
    List<Appointment> getAll();
}
