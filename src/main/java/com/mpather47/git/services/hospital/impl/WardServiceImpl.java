package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.repository.hospital.WardRepository;
import com.mpather47.git.repository.hospital.impl.WardRepositoryImpl;
import com.mpather47.git.services.hospital.WardService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WardServiceImpl implements WardService {

    private static WardService service = null;
    private WardRepository  repository;

    public WardServiceImpl() {
        this.repository = WardRepositoryImpl.getWardRepository();
    }

    public static WardService getService() {
        if (service == null)
            service = new WardServiceImpl();
        return service;
    }

    @Override
    public Ward create(Ward ward) {
        return repository.create(ward);
    }

    @Override
    public Ward read(Integer wardId) {
        return repository.read(wardId);
    }

    @Override
    public Ward update(Ward ward) {
        return repository.update(ward);
    }

    @Override
    public boolean delete(Integer wardId) {
        return repository.delete(wardId);
    }

    @Override
    public Set<Ward> getAll() {
        return repository.getAll();
    }
}
