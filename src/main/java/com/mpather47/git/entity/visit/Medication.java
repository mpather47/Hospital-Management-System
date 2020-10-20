package com.mpather47.git.entity.visit;

import java.io.Serializable;

public class Medication implements Serializable {
    private String prescriptionId, medicationId, visitId;
    private Medication(){}


    private Medication(Builder builder){
        this.medicationId = builder.medicationId;
        this.prescriptionId = builder.prescriptionId;
        this.visitId = builder.visitId;

    }

    public String getMedicationId(){return medicationId;}

    public String getPrescriptionId(){return prescriptionId;}

    public String getVisitId(){return visitId;}

    @Override
    public String toString() {
        return "Medication{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", medicationId='" + medicationId + '\'' +
                ", visitId='" + visitId + '\'' +
                '}';
    }

    public static class Builder{
        private String prescriptionId, medicationId, visitId;


        public Builder setMedicationId(String medicationId){
            this.medicationId = medicationId;
            return this;
        }

        public Builder setPrescriptionId(String prescriptionId){
            this.prescriptionId =prescriptionId;
            return this;
        }

        public Builder setVisit(String visitId){
            this.visitId = visitId;
            return this;
        }

        public Builder copyMedication(Medication medication) {
            this.medicationId = medication.medicationId;
            this.prescriptionId = medication.prescriptionId;
            this.visitId = medication.visitId;
            return this;
        }

        public Medication build(){
            return new Medication(this);

        }
    }
}
