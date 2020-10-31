/*
package com.mpather47.git.repository.hospital.impl;
import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.repository.hospital.HospitalRepository;

import java.util.HashSet;
import java.util.Set;
@Deprecated
public class HospitalRepositoryImpl implements HospitalRepository {
    private static HospitalRepository repository = null;
    private Set<Hospital> hospitalDB;

    private HospitalRepositoryImpl() {
        this.hospitalDB = new HashSet<>();
    }

    public static HospitalRepository getRepository() {
        if(repository == null) repository = new HospitalRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Hospital> getAll() {
        return this.hospitalDB;
    }

    @Override
    public Hospital create(Hospital hospital) {
        this.hospitalDB.add(hospital);
        return hospital;
    }

    @Override
    public Hospital read(String s) {
        Hospital hospital = this.hospitalDB.stream().filter(r -> r.getHospitalId().trim().equalsIgnoreCase(s)).findAny().orElse(null);
        return hospital;
    }

    @Override
    public Hospital update(Hospital hospital) {
        boolean deleteHospital = delete(hospital.getHospitalId());
        if (deleteHospital) {
            this.hospitalDB.add(hospital);
            return hospital;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Hospital hospital = read(s);
        if (hospital != null) {
            this.hospitalDB.remove(hospital);
            return true;
        }
        return false;
    }
}

*/
