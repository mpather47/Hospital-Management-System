package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.entity.visit.Prescription;

import com.mpather47.git.repository.visit.MedicationRepository;
import com.mpather47.git.repository.visit.PrescriptionRepository;
import com.mpather47.git.services.visit.MedicationService;
import com.mpather47.git.services.visit.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository repository;


    @Override
    public Set getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Prescription create(Prescription prescription) {
        return this.repository.save(prescription);
    }

    @Override
    public Prescription read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Prescription update(Prescription prescription) {
        if(this.repository.existsById(prescription.getPrescriptionId())) {
            return this.repository.save(prescription);
        }
        else
            return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))
            return false;
        else
            return true;
    }
}

