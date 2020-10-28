package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.repository.hospital.WardRepository;
import com.mpather47.git.services.hospital.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardServiceImpl implements WardService {

    private static WardService service = null;

    @Autowired
    private WardRepository  repository;

    public WardServiceImpl() {
    }

    public static WardService getService() {
        if (service == null)
            service = new WardServiceImpl();
        return service;
    }

    @Override
    public Ward create(Ward ward) {
        return repository.save(ward);
    }

    @Override
    public Ward read(Integer wardId) {
        Optional<Ward> wardOptional = repository.findById(wardId);
        return wardOptional.orElse(null);
    }

    @Override
    public Ward update(Ward ward) {
        return repository.save(ward);
    }

    @Override
    public boolean delete(Integer wardId) {
        if(read(wardId)!=null){
            repository.deleteById(wardId);
            return true;
        }
        return false;
    }

    @Override
    public List<Ward> getAll() {
        return repository.findAll();
    }
}
