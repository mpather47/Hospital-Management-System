package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.factory.hospital.EquipmentFactory;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.services.hospital.EquipmentService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquipmentServiceImplTest {
    private static List e;
    @Autowired
    private static EquipmentService service;
    private static Helper help = new Helper();
    private static Equipment equipment = EquipmentFactory.createEquipment(help.generateId(), "Scalpel", "Bladed Instrument utilized in surgery",
            4, "Room B");
    @Test
    public void d_testGetAll() {
        Set<Equipment> equipment = service.getAll();
        assertEquals(1,equipment.size());
        System.out.println("All equipment: " + equipment);
    }
    @Test
    public void a_testCreate() {
        Equipment created = service.create(equipment);
        Assert.assertEquals(equipment.getEquipmentId(), created.getEquipmentId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Equipment read = service.read(equipment.getEquipmentId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Equipment updated = new Equipment.Builder().copy(equipment).setName("Jumper").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(equipment.getEquipmentId());
        Assert.assertTrue(deleted);
    }
}



