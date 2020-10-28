/*
package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.repository.hospital.EquipmentRepository;
import java.util.HashSet;
import java.util.Set;

public class EquipmentRepositoryImpl implements EquipmentRepository {
    private static EquipmentRepository repository = null;
    private Set<Equipment> equipmentDB;

    private EquipmentRepositoryImpl() {
        this.equipmentDB = new HashSet<>();
    }

    public static EquipmentRepository getRepository() {
        if(repository == null) repository = new EquipmentRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Equipment> getAll() {
        return this.equipmentDB;
    }

    @Override
    public Equipment create(Equipment equipment) {
        this.equipmentDB.add(equipment);
        return equipment;
    }

    @Override
    public Equipment read(String s) {
        Equipment equipment = this.equipmentDB.stream().filter(r -> r.getEquipmentId().trim().equalsIgnoreCase(s)).findAny().orElse(null);
        return equipment;
    }

    @Override
    public Equipment update(Equipment equipment) {
        boolean deleteEquipment = delete(equipment.getEquipmentId());
        if (deleteEquipment) {
            this.equipmentDB.add(equipment);
            return equipment;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Equipment equipment = read(s);
        if (equipment != null) {
            this.equipmentDB.remove(equipment);
            return true;
        }
        return false;
    }
}
*/
