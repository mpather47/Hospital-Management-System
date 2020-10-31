package com.mpather47.git.services.employee.impl;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.repository.employee.EmployeeRepository;
import com.mpather47.git.repository.employee.impl.EmployeeRepositoryImpl;
import com.mpather47.git.services.employee.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService service=null;
    private EmployeeRepository repository;

    private EmployeeServiceImpl() {
        this.repository = EmployeeRepositoryImpl.getEmployeeRepository();
    }

    public static EmployeeService getService(){
        if(service==null) service = new EmployeeServiceImpl();
        return service;
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }
    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }
    @Override
    public Employee read(String s) {
        return this.repository.read(s);
    }
    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }
    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
