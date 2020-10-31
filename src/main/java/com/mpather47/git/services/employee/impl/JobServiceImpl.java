package com.mpather47.git.services.employee.impl;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.repository.employee.JobRepository;

import com.mpather47.git.services.employee.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service


public class JobServiceImpl   implements JobService {

    private static JobService service= null;

    @Autowired
    private JobRepository repository;



    @Override
    public Set<Job> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Job> getAllStartingWithA() {
        Set<Job> jobs = getAll();
        Set<Job>jobsWithA = new HashSet<>();
        for(Job job : jobs){

            if(job.getJobTittle().trim().toLowerCase().startsWith("a")){
                jobsWithA.add(job);


            }
        }
        return  jobsWithA;
    }

    @Override
    public Job create(Job job) {
        return this.repository.save(job);
    }

    @Override
    public Job read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Job update(Job job) {
        if (this.repository.existsById(job.getJobTittle())) {
            return this.repository.save(job);
        }
        return null;
    }


    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) return false;
        else return true;
    }
}
