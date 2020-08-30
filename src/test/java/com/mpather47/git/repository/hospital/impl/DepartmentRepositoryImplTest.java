package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.factory.hospital.DepartmentFactory;
import com.mpather47.git.repository.hospital.DepartmentRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentRepositoryImplTest {


    private static DepartmentRepository repository = DepartmentRepositoryImpl.getDepartmentRepository();
    private static Department department = DepartmentFactory.createDepartment(21,"The ward","The role");

    @Test
    public void a_create() {
        Department created = repository.create(department);
        assertEquals(department.getDepartmentId(), created.getDepartmentId());
    }

    @Test
    public void b_read() {
        Department read = repository.read(department.getDepartmentId());
        assertEquals(department.getDepartmentId(), read.getDepartmentId());
    }

    @Test
    public void c_update() {
        Department updated = new Department.DepartmentBuilder().copy(department).
                setRole("Bones").build();

        updated = repository.update(updated);
        assertEquals(department.getDepartmentId(), updated.getDepartmentId());
    }

    @Test
    public void e_delete() {
        repository.delete(department.getDepartmentId());
    }

    @Test
    public void d_getAll() {
        Set<Department> departments = repository.getAll();
        assertEquals(1, departments.size());
    }
}
