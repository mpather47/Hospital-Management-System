package com.mpather47.git.factory.visit;

import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.utility.Helper;

public class PrescriptionFactory {

    public static Prescription createPrescription(String medicationId,String visitId){
        String prescriptionId = Helper.generateId();
        return new Prescription.Builder().setPrescriptionId(prescriptionId).setMedicationId(medicationId).setVisitId(visitId).build();

    }
}
