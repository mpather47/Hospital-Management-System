package com.mpather47.git.factory.appointment;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
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