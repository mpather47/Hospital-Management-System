package com.mpather47.git.services.employee.impl;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.repository.employee.JobRepository;

import com.mpather47.git.services.employee.JobService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobServiceImplTest {

    @Autowired
    private  JobService service;
    private static Helper help = new Helper();
    private static Job job = JobFactory.createJob("Doctor");

    @Test
    public void d_testGetAll() {
        Set<Job> position = service.getAll();
        assertEquals(1,position.size());
        System.out.println("All people: " + position);
    }
    @Test
    public void a_testCreate() {
        Job created = service.create(job);
        Assert.assertEquals(job.getJobTittle(),created.getJobTittle());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Job read = service.read(job.getJobTittle());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Job updated = new Job.Builder().copy(job).setjobTittle("Nurse").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(job.getJobTittle());
        Assert.assertTrue(deleted);
    }
}



