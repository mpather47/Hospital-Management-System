package com.mpather47.git.entity.visit;

import java.io.Serializable;

public class Prescription implements Serializable {
    private String prescriptionId, medicationId, visitId;
    private Prescription(){}


    private Prescription(Builder builder) {
        this.prescriptionId = builder.prescriptionId;
        this.medicationId = builder.medicationId;
        this.visitId = builder.visitId;
    }


    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getMedicationId() {
        return medicationId;
    }

    public String getVisitId() {
        return visitId;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", medicationId='" + medicationId + '\'' +
                ", visitId='" + visitId + '\'' +
                '}';
    }

    public static class Builder{
        private String prescriptionId, medicationId, visitId;


        public Builder setPrescriptionId(String prescriptionId) {
            this.prescriptionId = prescriptionId;
            return this;
        }


        public Builder setMedicationId(String medicationId) {
            this.medicationId = medicationId;
            return this;
        }

        public Builder setVisitId(String visitId) {
            this.visitId = visitId;
            return this;
        }

        public Builder copyPrescription(Prescription prescription){
            this.prescriptionId = prescription.prescriptionId;
            this.medicationId = prescription.medicationId;
            this.visitId = prescription.visitId;
            return this;

        }

        public Prescription build(){
            return new Prescription(this);

        }
    }
}
