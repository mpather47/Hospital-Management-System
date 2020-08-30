package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.employee.Repository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JobRepositoryImplTest {

    private static JobRepository repository= new JobRepositoryImpl();
    private Job job = JobFactory.buildJob("DEVELOPERRRRR");

    @Test
    public void a_create() {

        Job created = repository.create(job);
        assertEquals(job.getJobTittle(), created.getJobTittle());



    }

    @Test
    public void b_read() {

        Job read = repository.read(job.getJobTittle());
        System.out.println(read);
        System.out.println("Read :: " + read);


    }

    @Test
    public void c_update() {
        Job updated =new Job.Builder().copy(job).setjobTittle("Developer").build();
        updated=repository.update(updated);
        System.out.println(updated);
        System.out.println("Update : " + updated);
    }

    @Test
    public void e_delete() {

      repository.delete(job.getJobTittle());
    }

    @Test
    public void d_getAll() {
        System.out.println(repository.getAll());
    }
}