/*
package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.factory.hospital.EquipmentFactory;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.repository.hospital.EquipmentRepository;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquipmentRepositoryImplTest {
    private static List e;
    @Autowired
    private static EquipmentRepository repository;
    private static Helper help = new Helper();
    private static Equipment equipment = EquipmentFactory.createEquipment(help.generateId(), "Scalpel", "Bladed Instrument utilized in surgery",
            4, RoomFactory.createRoom(help.generateId(),e , HospitalFactory.createHospital(help.generateId(), "St Mary", 1456)));


    @Test
    public void a_create(){
        Equipment created = repository.save(equipment);
        Assert.assertEquals(equipment.getEquipmentId(), created.getEquipmentId());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Equipment read = repository.findById(equipment.getEquipmentId()).orElseGet(null);
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Equipment updated = new Equipment.Builder().copy(equipment).setName("Jumper").build();
        updated = repository.save(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = false;
        repository.deleteById(equipment.getEquipmentId());
        if (repository.existsById(equipment.getEquipmentId())) {
            deleted = true;
        }
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.findAll());
    }


}*/
