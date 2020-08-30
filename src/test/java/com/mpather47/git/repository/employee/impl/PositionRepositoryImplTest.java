package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.factory.employee.PositionFactory;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.employee.PositionRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PositionRepositoryImplTest {

    private static PositionRepository repository= new PositionRepositoryImpl();
    private Position position = PositionFactory.buildJob("CEO");

    @Test
    public void a_create() {

        Position created = repository.create(position);
        assertEquals(position.getPositionCode(), created.getPositionStatus());
    }

    @Test
    public void b_read() {

        Position read = repository.read(position.getPositionCode());

        System.out.println(read);
        System.out.println("Read :: " + read);

    }

    @Test
    public void c_update() {
        Position updated =new Position.Builder().copy(position).setPositionCode("Ceo").build();
        updated=repository.update(updated);
        System.out.println(updated);
        System.out.println("Update : " + updated);
    }

    @Test
    public void e_delete() {

        repository.delete(position.getPositionCode());
        repository.delete(position.getPositionStatus());
    }

    @Test
    public void d_getAll() {

        System.out.println(repository.getAll());

    }
}