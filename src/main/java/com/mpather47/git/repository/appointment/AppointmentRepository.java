package com.mpather47.git.repository.appointment;
import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
   // List<Appointment> getAll();
}
