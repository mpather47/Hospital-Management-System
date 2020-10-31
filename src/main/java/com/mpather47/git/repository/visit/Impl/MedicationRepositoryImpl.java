/*
package com.mpather47.git.repository.visit.Impl;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.visit.MedicationRepository;
import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.visit.VisitationRepository;

import java.util.HashSet;
import java.util.Set;
@Deprecated
public class MedicationRepositoryImpl implements MedicationRepository {
    private static MedicationRepository repository=null;
    private Set<Medication> medicationDB;

    private MedicationRepositoryImpl() {this.medicationDB = new HashSet<>();}

    public static MedicationRepository getRepository(){
        if(repository==null) repository = new MedicationRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Medication> getAll() {
        return this.medicationDB;
    }

    @Override
    public Medication create(Medication medication) {
        this.medicationDB.add(medication);
        return medication;
    }

    @Override
    public Medication read(String id) {
        Medication medication = this.medicationDB.stream().filter(r -> r.getMedicationId().trim().equalsIgnoreCase(id))
                .findAny().orElse(null);
        return medication;
    }

    @Override
    public Medication update(Medication medication) {
        boolean deleteMedication= delete(medication.getMedicationId());
        if(deleteMedication){
            this.medicationDB.add(medication);
            return medication;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Medication medication = read(id);
        if(medication!= null){
            this.medicationDB.remove(medication);
            return true;
        }
        return false;
    }
}


*/
