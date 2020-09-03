package com.mpather47.git.factory.employee;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.factory.employee.JobFactory;
import org.junit.Assert;
import org.junit.Test;

public class JobFactoryTest {

    @Test
    public void createJob() {
        Job job = JobFactory.createJob("Tester");
       Assert.assertNotNull(job);



    }
}