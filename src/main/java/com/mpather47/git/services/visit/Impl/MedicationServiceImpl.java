package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.repository.person.AddressRepository;

import com.mpather47.git.repository.visit.MedicationRepository;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.visit.Impl.MedicationServiceImpl;
import com.mpather47.git.services.visit.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {


    @Autowired
    private MedicationRepository repository;


    @Override
    public Set<Medication> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Medication create(Medication medication) {
        return this.repository.save(medication);
    }

    @Override
    public Medication read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Medication  update(Medication  medication) {
        if(this.repository.existsById(medication.getVisitId())) {
            return this.repository.save(medication);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)){
            return false;
        }
        else
            return true;
    }
}


