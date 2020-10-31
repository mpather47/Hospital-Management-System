package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.repository.hospital.EquipmentRepository;
import com.mpather47.git.services.hospital.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentRepository repository;


    @Override
    public Set getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Equipment create(Equipment equipment) {
        return this.repository.save(equipment);
    }

    @Override
    public Equipment read(String s) {

        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Equipment update(Equipment equipment) {

        return this.repository.save(equipment);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (repository.existsById(s)) {
            return false;
        }
        else return true;
    }
}

