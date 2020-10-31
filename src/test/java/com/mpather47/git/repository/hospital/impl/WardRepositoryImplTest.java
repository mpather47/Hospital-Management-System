package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.factory.hospital.WardFactory;
import com.mpather47.git.repository.hospital.WardRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WardRepositoryImplTest {

    private static WardRepository repository = WardRepositoryImpl.getWardRepository();

    private static Ward ward = WardFactory.createWard(9, 5);

    @Test
    public void a_create() {
        Ward created = repository.create(ward);
        assertEquals(ward.getWardId(), created.getWardId());
    }

    @Test
    public void b_read() {
        Ward read = repository.read(ward.getWardId());
        assertEquals(ward.getWardId(), read.getWardId());
    }

    @Test
    public void c_update() {
        Ward updated = new Ward.WardBuilder().copy(ward).setWardSize(23).build();

        updated = repository.update(updated);
        assertEquals(ward.getWardId(), updated.getWardId());
    }

    @Test
    public void e_delete() {
        repository.delete(ward.getWardId());
        assertNull(repository.read(ward.getWardId()));
    }

    @Test
    public void d_getAll() {
        Set<Ward> wards = repository.getAll();
        assertEquals(1, wards.size());
    }

}
