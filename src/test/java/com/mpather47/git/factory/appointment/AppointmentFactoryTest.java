package com.mpather47.git.factory.appointment;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class AppointmentFactoryTest {
    @Test
    public void createAppointment(){
        Appointment appointment = AppointmentFactory.createAppointment(
                "124G",
                "LocalDate.of(2020,9,12)");

        LocalDate afterApp = LocalDate.of(2020,10,4);
        Assert.assertEquals(appointment.getBookingDate(), afterApp);
    }
}
