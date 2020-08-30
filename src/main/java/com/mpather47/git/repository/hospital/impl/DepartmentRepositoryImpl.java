package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.repository.hospital.DepartmentRepository;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private Set<Department> departments;
    private static DepartmentRepository departmentRepository = null;

    public DepartmentRepositoryImpl() {
        this.departments = new HashSet<>();
    }

    public static DepartmentRepository getDepartmentRepository(){
        if (departmentRepository == null)
            departmentRepository = new DepartmentRepositoryImpl();
        return departmentRepository;
    }

    @Override
    public Department create(Department department){
        departments.add(department);
        return department;
    }

    @Override
    public Department read(Integer departmentId){
        return departments.stream().filter(department -> department.getDepartmentId() == departmentId).
                findAny().orElse(null);
    }

    @Override
    public Department update(Department department){
        Department oldDepartment = read(department.getDepartmentId());
        if (oldDepartment != null){
            departments.remove(oldDepartment);
            departments.add(department);
        }
        return department;
    }

    @Override
    public boolean delete(Integer departmentId){
        boolean deleted = false;
        Department oldDepartment = read(departmentId);
        if (oldDepartment != null) {
            departments.remove(oldDepartment);
            deleted = true;
        }
        return deleted;
    }

    @Override
    public Set<Department> getAll() {
        return departments;
    }
}
