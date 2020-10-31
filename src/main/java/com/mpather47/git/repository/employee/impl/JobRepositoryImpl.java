/*package com.mpather47.git.repository.employee.impl;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.person.ContactRepository;
import com.mpather47.git.repository.person.PersonRepository;

import com.mpather47.git.utility.Helper;

import java.util.HashSet;
import java.util.Set;

public class JobRepositoryImpl implements JobRepository {
    private static JobRepository repository=null;
    private Set<Job> jobDB;

    private JobRepositoryImpl() {this.jobDB = new HashSet<>();}

    public static JobRepository getRepository(){
        if(repository==null) repository = new JobRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Job> getAll() {
        return this.jobDB;
    }

    @Override
    public Job create(Job job) {
        this.jobDB.add(job);
        return job;
    }

    @Override
    public Job read(String id) {
        Job job = this.jobDB.stream().filter(r -> r.getJobTittle().trim().equalsIgnoreCase(id))
                .findAny().orElse(null);
        return job;
    }

    @Override
    public Job update(Job job) {
        boolean deleteAddress = delete(job.getJobTittle());
        if(deleteAddress){
            this.jobDB.add(job);
            return job;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Job job = read(id);
        if(job != null){
            this.jobDB.remove(job);
            return true;
        }
        return false;
    }
}

 */
