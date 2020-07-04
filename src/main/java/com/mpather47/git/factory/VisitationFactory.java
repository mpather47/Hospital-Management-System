package com.mpather47.git.factory;

import com.mpather47.git.entity.Prescription;
import com.mpather47.git.entity.Visitation;
import java.util.Date;

public class VisitationFactory {
    public static Visitation createVisitation(String visitationId, String patientId,String doctorId,String prescriptionId,String visitDate){
        return new Visitation.Builder().setVisitId(visitationId).setPatientId(patientId).setDoctorId(doctorId).setPrescriptionId(prescriptionId).setVisitDate(visitDate).build();

    }
}
