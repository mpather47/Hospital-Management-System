package com.mpather47.git.services.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.services.employee.JobService;
import com.mpather47.git.services.employee.PositionService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PositionServiceImplTest {

    private static PositionService service = PositionServiceImpl.getService();
    private static Helper help = new Helper();
    private static Position position = PositionService.buildPoSition("PartTime");


    @Test
    public void d_getAll() {

        Set<Position> positions = service.getAll();
        assertEquals(1 ,positions.size());
        System.out.println("All positions: " + positions);

    }

    @Test
    public void a_create() {

        Position created = service .create(position);
        Assert.assertEquals(position.getPositionCode(), created.getPositionCode());
        System.out.println("Created: " + created);


    }

    @Test
    public void b_read() {

        Position read = service.read(position.getPositionCode());
        System.out.println("Read" + read);



    }

    @Test
    public void c_update() {

        Position updated = new Position.Builder().copy(position).setPositionCode("Fulltime").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);

    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(position.getPositionCode());
        Assert.assertTrue(deleted);


    }
}
