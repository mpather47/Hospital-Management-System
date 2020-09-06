package com.mpather47.git.services.employee.impl;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.factory.employee.EmployeeFactory;
import com.mpather47.git.services.employee.EmployeeService;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmployeeServiceImplTest {

    private static EmployeeService service = EmployeeServiceImpl.getService();
    private static Helper help = new Helper();
    private static Employee employee = EmployeeFactory.createEmployee("ND",new ArrayList<>(Arrays.asList("Xhosa","English"))
            , "ND IT");

    @Test
    public void d_getAll() {
        Set<Employee> employees = service.getAll();
        assertEquals(1, employees.size());
        System.out.println(".."+employees);

    }

    @Test
    public void a_create() {
        Employee created = service.create(employee);
        assertEquals(employee.getEmployeeID(), created.getEmployeeID());
        System.out.println(".."+created);
    }

    @Test
    public void b_read() {
        Employee read = service.read(employee.getEmployeeID());
        assertEquals(employee.getEmployeeID(), read.getEmployeeID());
    }

    @Test
    public void c_update() {
        Employee updated = new Employee.EmployeeBuilder().copy(employee).
                setEducation("Masters IT").build();

        updated = service.update(updated);
        assertEquals(employee.getEmployeeID(), updated.getEmployeeID());
    }

    @Test
    public void e_delete() {
        service.delete(employee.getEmployeeID());
    }
}
