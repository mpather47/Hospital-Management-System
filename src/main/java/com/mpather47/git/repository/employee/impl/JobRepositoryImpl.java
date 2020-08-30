package com.mpather47.git.repository.employee.impl;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.repository.employee.JobRepository;

import java.util.HashSet;
import java.util.Set;

public class JobRepositoryImpl implements JobRepository {

    private Set<Job> jobDB;

    public JobRepositoryImpl() {
        this.jobDB = new HashSet<>();
    }




@Override

    public Job create (Job job){

        this.jobDB.add(job);

        return job;
   }


@Override
public Job read (String jobId) {

    Job job = null;
    for (Job j : this.jobDB) {
        if (j.getJobTittle().equalsIgnoreCase(jobId))job=j;
        break;


    }
        return job;

}



@Override
public Job update (Job job ){

        Job oldJob = read(job.getJobTittle());
        if(oldJob != null){
            this.jobDB.remove(oldJob);
            this.jobDB.add(job);


        }

       return job;
}

@Override

public void delete (String jobId){
        Job job = read(jobId);
        if (job != null) this.jobDB.remove(job);

}

@Override
    public Set<Job> getAll() {
        return this.jobDB;
    }
}








