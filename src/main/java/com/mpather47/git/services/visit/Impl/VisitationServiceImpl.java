package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.person.AddressRepository;

import com.mpather47.git.repository.visit.VisitationRepository;
import com.mpather47.git.services.person.impl.AddressServiceImpl;
import com.mpather47.git.services.visit.PrescriptionService;
import com.mpather47.git.services.visit.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VisitationServiceImpl implements VisitationService {


    @Autowired
    private VisitationRepository repository;

    @Override
    public Set<Visitation> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Visitation create(Visitation visitation) {
        return this.repository.save(visitation);
    }

    @Override
    public Visitation read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Visitation update(Visitation visitation) {
        if(this.repository.existsById(visitation.getVisitId())){
            return this.repository.save(visitation);

        }

        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        else
            return true;
    }
}
