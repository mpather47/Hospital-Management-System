package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.factory.hospital.DepartmentFactory;
import com.mpather47.git.services.hospital.DepartmentService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentServiceImplTest {

    private static DepartmentService service = DepartmentServiceImpl.getService();
    private static Department department = DepartmentFactory.createDepartment(21,"The ward","The role");

    @Test
    public void a_create() {
        Department created = service.create(department);
        assertEquals(department, created);
    }

    @Test
    public void b_read() {
        Department read = service.read(department.getDepartmentId());
        assertEquals(department, read);
    }

    @Test
    public void c_update() {
        Department updated = new Department.DepartmentBuilder().copy(department).
                setRole("Bones").build();

        updated = service.update(updated);
        assertNotEquals(department, updated);
    }

    @Test
    public void e_delete() {
        service.delete(department.getDepartmentId());
    }

    @Test
    public void d_getAll() {
        Set<Department> departments = service.getAll();
        assertEquals(1, departments.size());
    }

}
