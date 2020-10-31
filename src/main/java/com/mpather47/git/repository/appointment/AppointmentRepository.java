package com.mpather47.git.repository.appointment;
import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface AppointmentRepository extends IRepository<Appointment, String> {
    Set<Appointment> getAll();
}
