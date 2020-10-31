package com.mpather47.git.entity.visit;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Visitation {
    @Id
    private String visitId;

    private String patientId;
    private String doctorId;
    private String prescriptionId;
    private String visitDate;

    protected Visitation(){}


    private Visitation(Builder builder){
        this.visitId = builder.visitId;
        this.patientId = builder.patientId;
        this.doctorId = builder.doctorId;
        this.prescriptionId = builder.prescriptionId;
        this.visitDate = builder.visitDate;

    }


    public String getVisitId() {
        return visitId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getVisitDate() {
        return visitDate;
    }



    @Override
    public String toString() {
        return "Visitation{" +
                "visitId='" + visitId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", prescriptionId='" + prescriptionId + '\'' +
                ", visitDate=" + visitDate +
                '}';
    }

    public static class Builder{
        private String visitId,patientId,doctorId,prescriptionId;
        private String visitDate;


        public Builder setVisitId(String visitId){
            this.visitId = visitId;
            return this;
        }

        public Builder setPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder setDoctorId(String doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder setPrescriptionId(String prescriptionId) {
            this.prescriptionId = prescriptionId;
            return this;
        }

        public Builder setVisitDate(String visitDate) {
            this.visitDate = visitDate;
            return this;
        }

        public Builder copyVisitation(Visitation visitation){
            this.visitId = visitation.visitId;
            this.patientId = visitation.patientId;
            this.doctorId = visitation.doctorId;
            this.prescriptionId = visitation.prescriptionId;
            this.visitDate = visitation.visitDate;
            return this;

        }
        public Visitation build(){
            return new Visitation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitation that = (Visitation) o;
        return visitId.equals(that.visitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitId);
    }
}
