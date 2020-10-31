package com.mpather47.git.entity.appointment;

import java.time.LocalDate;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private LocalDate bookingDate;

    public Appointment(){}
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

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }

    public static class AppointmentBuilder{
        private String appointmentId;
        private String patientId;
        private LocalDate bookingDate;

        public AppointmentBuilder(){}

        public AppointmentBuilder setAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public AppointmentBuilder setPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public AppointmentBuilder setBookingDate(LocalDate bookingDate) {
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
