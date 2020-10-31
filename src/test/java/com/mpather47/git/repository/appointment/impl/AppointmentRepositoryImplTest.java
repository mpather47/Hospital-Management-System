package com.mpather47.git.repository.appointment.impl;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
import com.mpather47.git.repository.appointment.AppointmentRepository;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentRepositoryImplTest {

    private static AppointmentRepository repository = AppointmentRepositoryImpl.getAppointmentRepository();

    private static Appointment appointment = AppointmentFactory.createAppointment(new Helper().generateId(),"3", LocalDate.of(2020,10,20));

    @Test
    public void a_create() {
        Appointment created = repository.create(appointment);
        assertEquals(appointment.getAppointmentId(), created.getAppointmentId());
    }

    @Test
    public void b_read() {
        Appointment read = repository.read(appointment.getAppointmentId());
        assertEquals(appointment.getAppointmentId(), read.getAppointmentId());
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.AppointmentBuilder().copy(appointment).
                setBookingDate(LocalDate.of(2020,11,3)).build();

        updated = repository.update(updated);
        assertEquals(appointment.getAppointmentId(), updated.getAppointmentId());
    }

    @Test
    public void e_delete() {
        repository.delete(appointment.getAppointmentId());
        assertNull(repository.read(appointment.getAppointmentId()));
    }

    @Test
    public void d_getAll() {
        Set<Appointment> appointments = repository.getAll();
        assertEquals(1, appointments.size());
    }
}
