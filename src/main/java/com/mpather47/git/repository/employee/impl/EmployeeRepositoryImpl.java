package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.repository.employee.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Set<Employee> employees;
    private static EmployeeRepository employeeRepository = null;

    public EmployeeRepositoryImpl() {
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getEmployeeRepository(){
        if (employeeRepository == null)
            employeeRepository = new EmployeeRepositoryImpl();
        return employeeRepository;
    }

    @Override
    public Employee create(Employee employee){
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(final String employeeId){
        return employees.stream().filter(employee -> employee.getEmployeeID().equals(employeeId)).
                findAny().orElse(null);
    }


    @Override
    public Employee update(Employee employee){
        Employee oldEmployee = read(employee.getEmployeeID());
        if (oldEmployee != null){
            employees.remove(oldEmployee);
            employees.add(employee);
        }

        return employee;
    }

    @Override
    public boolean delete(String employeeId){
        boolean deleted = false;
        Employee oldEmployee = read(employeeId);
        if (oldEmployee != null) {
            employees.remove(oldEmployee);
            deleted = true;
        }
        return deleted;
    }

    @Override
    public Set<Employee> getAll() {
        return employees;
    }
}
