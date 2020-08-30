package com.mpather47.git.factory.employee;
import com.mpather47.git.entity.employee.Job;


public class JobFactory {

public static Job createJob (String jobTittle){

    Job job= new Job.Builder().setjobTittle(jobTittle)
        .build();
        return job;


}


    public static Job buildJob(String jobTittle) {
        return null;
    }
}
