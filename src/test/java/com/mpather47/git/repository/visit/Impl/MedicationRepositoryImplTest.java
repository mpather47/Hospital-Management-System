//package com.mpather47.git.repository.visit.Impl;
//
//import com.mpather47.git.entity.person.Person;
//import com.mpather47.git.entity.visit.Medication;
//import com.mpather47.git.factory.person.PersonFactory;
//import com.mpather47.git.factory.visit.MedicationFactory;
//import com.mpather47.git.factory.visit.PrescriptionFactory;
//import com.mpather47.git.repository.visit.MedicationRepository;
//import com.mpather47.git.repository.visit.Impl.MedicationRepositoryImpl;
//import com.mpather47.git.utility.Helper;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//@Deprecated
//import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class MedicationRepositoryImplTest {
//    private static MedicationRepository repository = MedicationRepositoryImpl.getRepository();
//    private static Helper help = new Helper();
//    private static Medication medication = MedicationFactory.createMedication(help.generateId(), help.generateId(), help.generateId());
//
//    @Test
//    public void a_create(){
//        Medication created = repository.create(medication);
//        Assert.assertEquals(medication.getMedicationId(),created.getMedicationId());
//        System.out.println("Created:" + created);
//    }
//
//    @Test
//    public void b_read(){
//        Medication read = repository.read(medication.getMedicationId());
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Medication updated = new Medication.Builder().copyMedication(medication).setPrescriptionId("12").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void d_delete(){
//        boolean deleted = repository.delete(medication.getMedicationId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void e_getAll(){
//        System.out.println("Get all: " + repository.getAll());
//    }
//
//}