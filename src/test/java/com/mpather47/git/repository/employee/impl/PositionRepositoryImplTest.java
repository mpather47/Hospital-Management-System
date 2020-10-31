/*package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.factory.employee.PositionFactory;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.employee.PositionRepository;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.person.impl.AddressRepositoryImpl;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PositionRepositoryImplTest {

    private static PositionRepository repository ;
    private static Helper help = new Helper();
    private static Position position = PositionFactory.createPosition(help.generateId(),"full-time");


    @Test
    public void a_create(){
        Position created = repository.create(position);
        Assert.assertEquals(position.getPositionCode(),created.getPositionCode());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Position read = repository.read(position.getPositionCode());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Position updated = new Position.Builder().copy(position).setPositionStatus("Part-time").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(position.getPositionCode());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}

 */