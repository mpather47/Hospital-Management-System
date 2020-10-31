/*package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.person.PersonRepository;
import com.mpather47.git.repository.person.impl.AddressRepositoryImpl;
import com.mpather47.git.repository.person.impl.PersonRepositoryImpl;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JobRepositoryImplTest {
    private static JobRepository repository;
    private static Helper help = new Helper();
    private static Job job = JobFactory.createJob("Doctor");

    @Test
    public void a_create(){
        Job created = repository.create(job);
        Assert.assertEquals(job.getJobTittle(),created.getJobTittle());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Job read = repository.read(job.getJobTittle());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Job updated = new Job.Builder().copy(job).setjobTittle("Nurse").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(job.getJobTittle());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}

 */