package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.repository.hospital.HospitalRepository;;
import com.mpather47.git.services.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository repository;



    @Override
    public Set getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Hospital create(Hospital hospital) {
        return this.repository.save(hospital);
    }

    @Override
    public Hospital read(String s) {

        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Hospital update(Hospital hospital) {

        return this.repository.save(hospital);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) {
            return false;
        }
        else return true;
    }
}