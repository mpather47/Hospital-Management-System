package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.repository.hospital.HospitalRepository;
import com.mpather47.git.repository.hospital.impl.HospitalRepositoryImpl;
import com.mpather47.git.services.hospital.HospitalService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class HospitalServiceImpl implements HospitalService {
    private static HospitalService service=null;
    private HospitalRepository repository;

    private HospitalServiceImpl() {
        this.repository = HospitalRepositoryImpl.getRepository();
    }

    public static HospitalService getService(){
        if(service==null) service = new HospitalServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {
        return this.repository.getAll();
    }

    @Override
    public Hospital create(Hospital hospital) {
        return this.repository.create(hospital);
    }

    @Override
    public Hospital read(String s) {

        return this.repository.read(s);
    }

    @Override
    public Hospital update(Hospital hospital) {

        return this.repository.update(hospital);
    }

    @Override
    public boolean delete(String s) {

        return this.repository.delete(s);
    }
}