package com.mpather47.git.services.employee;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface JobService extends IService<Job,String> {

    Set<Job>getAll();
}
