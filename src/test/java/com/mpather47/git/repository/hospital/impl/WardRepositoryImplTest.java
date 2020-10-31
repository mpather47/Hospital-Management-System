package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.factory.hospital.WardFactory;
import com.mpather47.git.repository.hospital.WardRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WardRepositoryImplTest {

    @Autowired
    private static WardRepository repository;

    private static Ward ward = WardFactory.createWard(9, 5);

    @Test
    public void a_create() {
        Ward created = repository.save(ward);
        assertEquals(ward.getWardId(), created.getWardId());
    }

    @Test
    public void b_read() {
        Optional<Ward> read = repository.findById(ward.getWardId());
        assertNotNull(read.orElse(null));
    }

    @Test
    public void c_update() {
        Ward updated = new Ward.WardBuilder().copy(ward).setWardSize(23).build();

        updated = repository.save(updated);
        assertEquals(ward.getWardId(), updated.getWardId());
    }

    @Test
    public void e_delete() {
        repository.deleteById(ward.getWardId());
        Optional<Ward> read = repository.findById(ward.getWardId());
        assertNotNull(read.orElse(null));
    }

    @Test
    public void d_getAll() {
        List<Ward> wards = repository.findAll();
        assertEquals(1, wards.size());
    }

}
