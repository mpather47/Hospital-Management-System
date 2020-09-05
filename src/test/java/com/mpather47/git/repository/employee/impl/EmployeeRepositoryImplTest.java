
package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.factory.employee.EmployeeFactory;
import com.mpather47.git.repository.employee.EmployeeRepository;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private static EmployeeRepository repository = EmployeeRepositoryImpl.getEmployeeRepository();
    private Employee employee = EmployeeFactory.createEmployee("ND",new ArrayList<>(Arrays.asList("Xhosa","English")), "ND IT");

    @Test
    public void a_create() {
        Employee created = repository.create(employee);
        assertEquals(employee.getEmployeeID(), created.getEmployeeID());
        System.out.println("create: "+created);
    }

    @Test
    public void b_read() {
        Employee read = repository.read(employee.getEmployeeID());
//        assertEquals(employee.getEmployeeID(), read.getEmployeeID());
        System.out.println("read: "+read);
    }

    @Test
    public void c_update() {
        Employee updated = new Employee.EmployeeBuilder().copy(employee).
                setEducation("Masters IT").build();

        updated = repository.update(updated);
        assertEquals(employee.getEmployeeID(), updated.getEmployeeID());
        System.out.println("updated: "+updated);
    }

    @Test
    public void e_delete() {
        repository.delete(employee.getEmployeeID());
    }

    @Test
    public void d_getAll() {
        Set<Employee> employees = repository.getAll();
        assertEquals(1, employees.size());
        System.out.println("All: "+repository.getAll());
    }
}
