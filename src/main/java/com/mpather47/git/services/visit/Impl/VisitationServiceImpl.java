package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.visit.Impl.VisitationRepositoryImpl;
import com.mpather47.git.repository.visit.VisitationRepository;
import com.mpather47.git.services.person.impl.AddressServiceImpl;
import com.mpather47.git.services.visit.PrescriptionService;
import com.mpather47.git.services.visit.VisitationService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VisitationServiceImpl implements VisitationService {

    private static VisitationService service = null;
    private VisitationRepository repository;

    private VisitationServiceImpl(){this.repository = VisitationRepositoryImpl.getRepository();}

    public static VisitationService getService(){
        if(service==null) service = new VisitationServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Visitation create(Visitation visitation) {
        return this.repository.create(visitation);
    }

    @Override
    public Visitation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Visitation update(Visitation visitation) {
        return this.repository.update(visitation);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
