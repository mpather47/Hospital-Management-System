package com.mpather47.git.repository.employee;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
