package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.factory.hospital.WardFactory;
import com.mpather47.git.services.hospital.WardService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WardServiceImplTest {

    private static WardService service = WardServiceImpl.getService();
    private static Ward ward = WardFactory.createWard(9, 5);

    @Test
    public void a_create() {
        Ward created = service.create(ward);
        assertEquals(ward.getWardId(), created.getWardId());
    }

    @Test
    public void b_read() {
        Ward read = service.read(ward.getWardId());
        assertEquals(ward.getWardId(), read.getWardId());
    }

    @Test
    public void c_update() {
        Ward updated = new Ward.WardBuilder().copy(ward).setWardSize(23).build();

        updated = service.update(updated);
        assertEquals(ward.getWardId(), updated.getWardId());
    }

    @Test
    public void e_delete() {
        service.delete(ward.getWardId());
        assertNull(service.read(ward.getWardId()));
    }

    @Test
    public void d_getAll() {
        List<Ward> wards = service.getAll();
        assertEquals(1, wards.size());
    }


}
