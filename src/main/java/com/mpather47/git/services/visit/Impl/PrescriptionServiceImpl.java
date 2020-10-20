package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.repository.visit.Impl.MedicationRepositoryImpl;
import com.mpather47.git.repository.visit.Impl.PrescriptionRepositoryImpl;
import com.mpather47.git.repository.visit.MedicationRepository;
import com.mpather47.git.repository.visit.PrescriptionRepository;
import com.mpather47.git.services.visit.MedicationService;
import com.mpather47.git.services.visit.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    private static PrescriptionService service=null;
    private PrescriptionRepository repository;

    private PrescriptionServiceImpl() {
        this.repository = PrescriptionRepositoryImpl.getRepository();
    }

    public static PrescriptionService getService(){
        if(service==null) service = new PrescriptionServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Prescription create(Prescription prescription) {
        return this.repository.create(prescription);
    }

    @Override
    public Prescription read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Prescription update(Prescription prescription) {
        return this.repository.update(prescription);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}

