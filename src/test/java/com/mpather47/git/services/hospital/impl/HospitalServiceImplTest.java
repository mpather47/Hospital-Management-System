package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.services.hospital.HospitalService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HospitalServiceImplTest {
    @Autowired
    private static HospitalService service;
    private static Helper help = new Helper();
    private static Hospital hospital = HospitalFactory.createHospital(help.generateId(), "St Mary", 2456);
    @Test
    public void d_testGetAll() {
        Set<Hospital> hospital = service.getAll();
        assertEquals(1,hospital.size());
        System.out.println("All hospitals: " + hospital);
    }
    @Test
    public void a_testCreate() {
        Hospital created = service.create(hospital);
        Assert.assertEquals(hospital.getHospitalId(), created.getHospitalId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Hospital read = service.read(hospital.getHospitalId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Hospital updated = new Hospital.Builder().copy(hospital).setHospitalName("St Mary").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(hospital.getHospitalId());
        Assert.assertTrue(deleted);
    }
}

