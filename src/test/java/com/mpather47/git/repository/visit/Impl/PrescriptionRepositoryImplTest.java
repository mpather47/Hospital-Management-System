//package com.mpather47.git.repository.visit.Impl;
//import com.mpather47.git.entity.person.Person;
//import com.mpather47.git.entity.visit.Prescription;
//import com.mpather47.git.factory.visit.PrescriptionFactory;
//import com.mpather47.git.repository.visit.PrescriptionRepository;
//import com.mpather47.git.utility.Helper;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.*;
//
//@Deprecated
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PrescriptionRepositoryImplTest {
//    private static PrescriptionRepository repository = PrescriptionRepositoryImpl.getRepository();
//    private static Helper help = new Helper();
//    private static Prescription prescription = PrescriptionFactory.createPrescription(help.generateId(),help.generateId(),help.generateId());
//
//
//
//    @Test
//    public void a_create() {
//        Prescription create = repository.create(prescription);
//        Assert.assertEquals(prescription.getPrescriptionId(),create.getPrescriptionId());
//        System.out.println("Created "+ create);
//    }
//
//    @Test
//    public void b_read() {
//        Prescription read = repository.read(prescription.getPrescriptionId());
//        System.out.println("Read:" + read);
//
//    }
//
//    @Test
//    public void c_update() {
//        Prescription updated = new Prescription.Builder().copyPrescription(prescription).setMedicationId("53").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void d_delete() {
//        boolean deleted = repository.delete(prescription.getPrescriptionId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void e_getAll() {
//        System.out.println("Get all: " + repository.getAll());
//
//    }
//
//}