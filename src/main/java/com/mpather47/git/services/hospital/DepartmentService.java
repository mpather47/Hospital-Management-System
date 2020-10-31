package com.mpather47.git.services.hospital;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.services.IService;
import java.util.Set;

public interface DepartmentService extends IService<Department, Integer> {
    Set<Department> getAll();
}
