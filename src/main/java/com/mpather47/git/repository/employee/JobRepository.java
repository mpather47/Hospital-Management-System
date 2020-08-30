package com.mpather47.git.repository.employee;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;

import java.util.Set;

public interface JobRepository extends Repository <Job, String>{


    Set<Job> getAll();

}
