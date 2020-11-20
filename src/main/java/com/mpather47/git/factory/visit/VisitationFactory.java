package com.mpather47.git.factory.visit;

import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.utility.Helper;

public class VisitationFactory {
    public static Visitation createVisitation(String patientId,String doctorId,String prescriptionId,String visitDate){
        String visitationId = Helper.generateId();
        return new Visitation.Builder().setVisitId(visitationId).setPatientId(patientId).setDoctorId(doctorId).setPrescriptionId(prescriptionId).setVisitDate(visitDate).build();

    }
}
