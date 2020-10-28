package com.mpather47.git.services.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
import com.mpather47.git.services.appointment.AppointmentService;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentServiceImplTest {

    @Autowired
    private AppointmentServiceImpl service;
    private static Appointment appointment = AppointmentFactory.createAppointment(new Helper().generateId(),"3", LocalDate.of(2020,10,20));

    @Test
    public void a_create() {
        Appointment created = service.create(appointment);
        assertEquals(appointment.getAppointmentId(), created.getAppointmentId());
    }

    @Test
    public void b_read() {
        Appointment read = service.read(appointment.getAppointmentId());
        assertEquals(appointment.getAppointmentId(), read.getAppointmentId());
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).
                setBookingDate(LocalDate.of(2020,11,3)).build();

        updated = service.update(updated);
        assertNotEquals(appointment, updated);
    }

    @Test
    public void e_delete() {
        service.delete(appointment.getAppointmentId());
        assertNull(service.read(appointment.getAppointmentId()));
    }

    @Test
    public void d_getAll() {
        List<Appointment> appointments = service.getAll();
        assertEquals(1, appointments.size());
    }

}
