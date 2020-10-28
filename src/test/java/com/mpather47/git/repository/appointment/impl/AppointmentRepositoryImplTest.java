package com.mpather47.git.repository.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
import com.mpather47.git.repository.appointment.AppointmentRepository;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentRepositoryImplTest {

    @Autowired
    private static AppointmentRepository repository;

    private static Appointment appointment = AppointmentFactory.createAppointment(new Helper().generateId(),"3", LocalDate.of(2020,10,20));

    @Test
    public void a_create() {
        Appointment created = repository.save(appointment);
        assertEquals(appointment.getAppointmentId(), created.getAppointmentId());
    }

    @Test
    public void b_read() {
        Optional<Appointment> read = repository.findById(appointment.getAppointmentId());
        assertNotNull(read.orElse(null));
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).
                setBookingDate(LocalDate.of(2020,11,3)).build();

        updated = repository.save(updated);
        assertEquals(appointment.getAppointmentId(), updated.getAppointmentId());
    }

    @Test
    public void e_delete() {
        repository.deleteById(appointment.getAppointmentId());
        Optional<Appointment> read = repository.findById(appointment.getAppointmentId());
        assertNotNull(read.orElse(null));
    }

    @Test
    public void d_getAll() {
        List<Appointment> appointments = repository.findAll();
        assertEquals(1, appointments.size());
    }
}
