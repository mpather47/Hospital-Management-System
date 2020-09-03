package com.mpather47.git.factory.visit;

import com.mpather47.git.entity.visit.Medication;

public class MedicationFactory {
    public static Medication createMedication(String medicationId, String prescriptionId, String visitId){
        return new Medication.Builder().setMedicationId(medicationId).setPrescriptionId(prescriptionId).setVisit(visitId).build();
    }
}
