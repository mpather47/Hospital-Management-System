package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.factory.visit.MedicationFactory;
import com.mpather47.git.factory.visit.VisitationFactory;
import com.mpather47.git.services.visit.MedicationService;
import com.mpather47.git.services.visit.VisitationService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicationServiceImplTest {
    private static MedicationService service;
    private static Helper help = new Helper();
    private static Medication medication= MedicationFactory.createMedication(help.generateId(),help.generateId(),help.generateId());

    @Test
    public void d_testGetAll() {
        Set<Medication> medication = service.getAll();
        assertEquals(1,medication.size());
        System.out.println("All people: " + medication);
    }
    @Test
    public void a_testCreate() {
        Medication created = service.create(medication);
        assertEquals(medication.getVisitId(),created.getVisitId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
       Medication read = service.read(medication.getMedicationId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Medication updated = new Medication.Builder().copyMedication(medication).setVisit("625").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(medication.getMedicationId());
        Assert.assertTrue(deleted);
    }
}