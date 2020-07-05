package com.mpather47.git.factory;

import com.mpather47.git.entity.Appointment;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class AppointmentFactoryTest {
    @Test
    public void createAppointment(){
        Appointment appointment = AppointmentFactory.createAppointment(
                "102C3",
                "124G",
                new Date());

        Date afterApp = new Date();
        Assert.assertTrue(appointment.getBookingDate().before(afterApp));
    }
}