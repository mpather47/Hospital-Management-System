package com.mpather47.git.repository.hospital;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface DepartmentRepository extends IRepository<Department, Integer> {
    Set<Department> getAll();
}
