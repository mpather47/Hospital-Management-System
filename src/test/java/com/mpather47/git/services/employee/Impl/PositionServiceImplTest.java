package com.mpather47.git.services.employee.Impl;

import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.factory.employee.PositionFactory;
import com.mpather47.git.repository.employee.PositionRepository;
import com.mpather47.git.repository.employee.impl.PositionRepositoryImpl;
import com.mpather47.git.services.employee.PositionService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionServiceImplTest {

    private static PositionService service = PositionServiceImpl.getService();
    private static Helper help = new Helper();
    private static Position position = PositionFactory.createPosition(help.generateId(),"full-time");

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + service.getAll());
    }

    @Test
    public void a_create() {
        Position created = service.create(position);
        Assert.assertEquals(position.getPositionCode(),created.getPositionCode());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read() {
        Position read = service.read(position.getPositionCode());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Position updated = new Position.Builder().copy(position).setPositionStatus("Part-time").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(position.getPositionCode());
        Assert.assertTrue(deleted);
    }
}