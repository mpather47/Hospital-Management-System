package com.mpather47.git.entity.appointment;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private Date bookingDate;

    public Appointment (AppointmentBuilder appointmentBuilder){
        this.appointmentId = appointmentBuilder.appointmentId;
        this.patientId = appointmentBuilder.patientId;
        this.bookingDate = appointmentBuilder.bookingDate;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public static class AppointmentBuilder{
        private String appointmentId;
        private String patientId;
        private Date bookingDate;

        public AppointmentBuilder(){}

        public AppointmentBuilder setAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public AppointmentBuilder setPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public AppointmentBuilder setBookingDate(Date bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Appointment build()
        {
            return new Appointment(this);
        }

        public AppointmentBuilder copy(Appointment appointment){
            this.appointmentId = appointment.appointmentId;
            this.patientId = appointment.patientId;
            this.bookingDate = appointment.bookingDate;
            return this;
        }
    }

}
