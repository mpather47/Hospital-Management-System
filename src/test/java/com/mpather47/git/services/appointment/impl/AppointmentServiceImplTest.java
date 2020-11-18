package com.mpather47.git.services.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
import com.mpather47.git.services.appointment.AppointmentService;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentServiceImplTest {

    private AppointmentService service = AppointmentServiceImpl.getService();
    private static Appointment appointment = AppointmentFactory.createAppointment("3", "LocalDate.of(2020,10,20)");

    @Test
    public void a_create() {
        Appointment created = service.create(appointment);
        assertEquals(appointment, created);
    }

    @Test
    public void b_read() {
        Appointment read = service.read(appointment.getAppointmentId());
        assertEquals(appointment, read);
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).
                setBookingDate("LocalDate.of(2020,11,3)").build();

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
        Set<Appointment> appointments = service.getAll();
        assertEquals(1, appointments.size());
    }

}
