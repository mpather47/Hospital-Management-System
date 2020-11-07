//package com.mpather47.git.repository.visit.Impl;
//
//import com.mpather47.git.entity.visit.Visitation;
//
//import com.mpather47.git.factory.visit.VisitationFactory;
//
//
//import com.mpather47.git.repository.visit.VisitationRepository;
//import com.mpather47.git.utility.Helper;
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.*;
//@Deprecated
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class VisitationRepositoryImplTest {
//
//    private static VisitationRepository repository = VisitationRepositoryImpl.getRepository();
//    private static Helper help = new Helper();
//    private static Visitation visitation = VisitationFactory.createVisitation(help.generateId(),help.generateId(),help.generateId(),help.generateId(),"2020/05/7");
//
//    @Test
//    public void a_create(){
//        Visitation created = repository.create(visitation);
//        Assert.assertEquals(visitation.getVisitId(),created.getVisitId());
//        System.out.println("Created:" + created);
//    }
//
//    @Test
//    public void b_read(){
//        Visitation read = repository.read(visitation.getVisitId());
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Visitation updated = new Visitation.Builder().copyVisitation(visitation).setVisitDate("2020/05/8").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void d_delete(){
//        boolean deleted = repository.delete(visitation.getVisitId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void e_getAll(){
//        System.out.println("Get all: " + repository.getAll());
//    }
//
//}
//
