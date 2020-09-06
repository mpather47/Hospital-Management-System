package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.repository.hospital.EquipmentRepository;
import com.mpather47.git.repository.hospital.impl.EquipmentRepositoryImpl;
import com.mpather47.git.services.hospital.EquipmentService;

import java.util.Set;

public class EquipmentServiceImpl implements EquipmentService {
    private static EquipmentService service = null;
    private EquipmentRepository repository;

    private EquipmentServiceImpl() {
        this.repository = EquipmentRepositoryImpl.getRepository();
    }

    public static EquipmentService getService() {
        if (service == null) service = new EquipmentServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {

        return this.repository.getAll();
    }

    @Override
    public Equipment create(Equipment equipment) {
        return this.repository.create(equipment);
    }

    @Override
    public Equipment read(String s) {

        return this.repository.read(s);
    }

    @Override
    public Equipment update(Equipment equipment) {

        return this.repository.update(equipment);
    }

    @Override
    public boolean delete(String s) {

        return this.repository.delete(s);
    }
}

