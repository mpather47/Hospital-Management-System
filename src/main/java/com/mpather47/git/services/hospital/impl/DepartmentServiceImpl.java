package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.repository.hospital.DepartmentRepository;
import com.mpather47.git.repository.hospital.impl.DepartmentRepositoryImpl;
import com.mpather47.git.services.hospital.DepartmentService;

import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {

    private static DepartmentService service = null;
    private DepartmentRepository repository;

    public DepartmentServiceImpl() {
        this.repository = DepartmentRepositoryImpl.getDepartmentRepository();
    }

    public static DepartmentService getService() {
        if (service==null)
            service = new DepartmentServiceImpl();
        return service;
    }

    @Override
    public Set<Department> getAll() {
        return repository.getAll();
    }

    @Override
    public Department create(Department department) {
        return repository.create(department);
    }

    @Override
    public Department read(Integer depCode) {
        return repository.read(depCode);
    }

    @Override
    public Department update(Department department) {
        return repository.update(department);
    }

    @Override
    public boolean delete(Integer depCode) {
        return repository.delete(depCode);
    }
}
