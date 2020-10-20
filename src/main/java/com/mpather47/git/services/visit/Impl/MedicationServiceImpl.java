package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.visit.Impl.MedicationRepositoryImpl;
import com.mpather47.git.repository.visit.MedicationRepository;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.visit.Impl.MedicationServiceImpl;
import com.mpather47.git.services.visit.MedicationService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MedicationServiceImpl implements MedicationService {

    private static MedicationService service=null;
    private MedicationRepository repository;

    private MedicationServiceImpl() {
        this.repository = MedicationRepositoryImpl.getRepository();
    }

    public static MedicationService getService(){
        if(service==null) service = new MedicationServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Medication create(Medication medication) {
        return this.repository.create(medication);
    }

    @Override
    public Medication read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Medication  update(Medication  medication) {
        return this.repository.update(medication);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}


