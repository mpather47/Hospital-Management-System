package com.mpather47.git.factory;

import com.mpather47.git.entity.Appointment;

import java.util.Date;

public class AppointmentFactory{

    public static Appointment createAppointment(String appointmentId, String patientId, Date bookingDate){

        return new Appointment.AppointmentBuilder().
                setAppointmentId(appointmentId).
                setPatientId(patientId).
                setBookingDate(bookingDate).build();
    }
}
