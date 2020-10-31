/*
package com.mpather47.git.repository.visit.Impl;

import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.repository.visit.PrescriptionRepository;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.visit.VisitationRepository;

import java.util.HashSet;
import java.util.Set;
@Deprecated
public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    private static PrescriptionRepository repository=null;
    private Set<Prescription> prescriptionDB;

    private PrescriptionRepositoryImpl() {this.prescriptionDB = new HashSet<>();}

    public static PrescriptionRepository getRepository(){
        if(repository==null) repository = new PrescriptionRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Prescription> getAll() {
        return this.prescriptionDB;
    }


    @Override
    public Prescription create(Prescription prescription) {
        this.prescriptionDB.add(prescription);
        return prescription;
    }

    @Override
    public Prescription read(String id) {
        Prescription prescription= this.prescriptionDB.stream().filter(r -> r.getPrescriptionId().trim().equalsIgnoreCase(id))
                .findAny().orElse(null);
        return prescription;
    }

    @Override
    public Prescription update(Prescription prescription) {
        boolean deletePrescription = delete(prescription.getPrescriptionId());
        if(deletePrescription){
            this.prescriptionDB.add(prescription);
            return prescription;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Prescription prescription = read(id);
        if(prescription != null){
            this.prescriptionDB.remove(prescription);
            return true;
        }
        return false;
    }
}
*/
