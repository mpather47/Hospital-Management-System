package com.mpather47.git.services.employee.impl;



import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.employee.PositionFactory;
import com.mpather47.git.repository.employee.PositionRepository;
import com.mpather47.git.services.employee.PositionService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PositionServiceImplTest {

    @Autowired
    private  PositionService service ;
    private static Helper help = new Helper();
    private static Position position = PositionFactory.createPosition(help.generateId(),"full-time");

    @Test
    public void d_testGetAll() {
        Set<Position> position = service.getAll();
        assertEquals(1,position.size());
        System.out.println("All people: " + position);
    }
    @Test
    public void a_testCreate() {
        Position created = service.create(position);
        Assert.assertEquals(position.getPositionCode(),created.getPositionCode());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Position read = service.read(position.getPositionCode());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Position updated = new Position.Builder().copy(position).setPositionStatus("Part-Time").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(position.getPositionCode());
        Assert.assertTrue(deleted);
    }

}


