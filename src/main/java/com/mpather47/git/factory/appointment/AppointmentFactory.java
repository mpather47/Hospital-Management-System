package com.mpather47.git.factory.appointment;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.utility.Helper;

import java.time.LocalDate;

public class AppointmentFactory{

    public static Appointment createAppointment(String patientId, String bookingDate){
        String appointmentId = Helper.generateId();
        return new Appointment.AppointmentBuilder().
                setAppointmentId(appointmentId).
                setPatientId(patientId).
                setBookingDate(bookingDate).build();
    }
}
