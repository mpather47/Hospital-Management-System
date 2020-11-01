package com.mpather47.git.services.visit.Impl;

import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.visit.VisitationFactory;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.person.impl.AddressServiceImpl;
import com.mpather47.git.services.visit.VisitationService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisitationServiceImplTest {
    private static VisitationService service;
    private static Helper help = new Helper();
    private static Visitation visitation = VisitationFactory.createVisitation(help.generateId(),"13","1123","7032","2020/05/7");

    @Test
    public void d_testGetAll() {
        Set<Visitation> visitation = service.getAll();
        assertEquals(1,visitation.size());
        System.out.println("All people: " + visitation);
    }
    @Test
    public void a_testCreate() {
        Visitation created = service.create(visitation);
        Assert.assertEquals(visitation.getVisitId(),created.getVisitId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
    Visitation read = service.read(visitation.getVisitId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
      Visitation updated = new Visitation.Builder().copyVisitation(visitation).setVisitDate("21/08/20").setPatientId("66").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(visitation.getVisitId());
        Assert.assertTrue(deleted);
    }
}