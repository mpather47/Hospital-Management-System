package com.mpather47.git.factory;

import com.mpather47.git.entity.Medication;
import com.mpather47.git.entity.Prescription;

public class MedicationFactory {
    public static Medication createMedication(String medicationId, String prescriptionId, String visitId){
        return new Medication.Builder().setMedicationId(medicationId).setPrescriptionId(prescriptionId).setVisit(visitId).build();
    }
}
