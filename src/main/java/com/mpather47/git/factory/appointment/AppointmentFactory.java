package com.mpather47.git.factory.appointment;

import com.mpather47.git.entity.appointment.Appointment;

import java.time.LocalDate;

public class AppointmentFactory{

    public static Appointment createAppointment(String appointmentId, String patientId, LocalDate bookingDate){

        return new Appointment.AppointmentBuilder().
                setAppointmentId(appointmentId).
                setPatientId(patientId).
                setBookingDate(bookingDate).build();
    }
}
