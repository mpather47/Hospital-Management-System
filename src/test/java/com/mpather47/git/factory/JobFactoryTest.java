package com.mpather47.git.factory;

import com.mpather47.git.entity.Job;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobFactoryTest {

    @Test
    public void createJob() {
        Job job = JobFactory.createJob("Tester");
       Assert.assertNotNull(job);



    }
}