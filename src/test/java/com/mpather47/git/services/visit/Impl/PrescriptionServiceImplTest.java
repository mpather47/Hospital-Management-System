package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Prescription;

import com.mpather47.git.factory.visit.PrescriptionFactory;

import com.mpather47.git.services.visit.PrescriptionService;

import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Set;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PrescriptionServiceImplTest {
    private static PrescriptionService service;
    private static Helper help = new Helper();
    private static Prescription prescription = PrescriptionFactory.createPrescription(help.generateId(),help.generateId(),help.generateId());

    @Test
    public void d_testGetAll() {
        Set<Prescription> prescription= service.getAll();
        assertEquals(1,prescription.size());
        System.out.println("All people: " + prescription);
    }
    @Test
    public void a_testCreate() {
        Prescription created = service.create(prescription);
        Assert.assertEquals(prescription.getPrescriptionId(),created.getPrescriptionId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Prescription read = service.read(prescription.getPrescriptionId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Prescription updated = new Prescription.Builder().copyPrescription(prescription).setMedicationId("352").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(prescription.getPrescriptionId());
        Assert.assertTrue(deleted);
    }
}