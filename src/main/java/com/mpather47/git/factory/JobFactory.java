package com.mpather47.git.factory;
import com.mpather47.git.entity.Job;
import com.mpather47.git.entity.Position;


public class JobFactory {

public static Job createJob (String jobTittle){

    Job job= new Job.Builder().setjobTittle(jobTittle)
        .build();
        return job;


}



}
