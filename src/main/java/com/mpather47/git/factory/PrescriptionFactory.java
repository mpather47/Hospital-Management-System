package com.mpather47.git.factory;

import com.mpather47.git.entity.Prescription;

public class PrescriptionFactory {

    public static Prescription createPrescription(String prescriptionId, String medicationId,String visitId){
        return new Prescription.Builder().setPrescriptionId(prescriptionId).setMedicationId(medicationId).setVisitId(visitId).build();

    }
}
