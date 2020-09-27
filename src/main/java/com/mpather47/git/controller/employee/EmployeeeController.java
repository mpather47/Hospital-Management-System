package com.mpather47.git.controller.employee;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.factory.employee.EmployeeFactory;
import com.mpather47.git.services.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/employee")

public class EmployeeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @PostMapping("/create ")

    public Employee create(@RequestBody Employee employee)
    {
        boolean employeeExist = false;
        Employee newEmployee = EmployeeFactory.createEmployee(employee.getEducation(),employee.getLanguages(), employee.getCertification());
        if (newEmployee != null) {
            employeeExist = true;
        }
        if (employeeExist) {
            return employeeService.create(newEmployee);
        }
        else
            return EmployeeFactory.createEmployee(null, null, null);
    }
    @GetMapping("/read/{id}")
    public Employee read(@PathVariable String id)
    {
        boolean employeeExist = false;
        if (id != null) {
            employeeExist = true;
        }

        if (employeeExist) {
            return employeeService.read(id);
        }
        else
            return null;
    }
    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee)
    {
        boolean employeeExist = false;
        if (employee != null) {
            employeeExist = true;
        }

        if (employeeExist) {
            return employeeService.update(employee);
        }
        else return null;
    }
    @GetMapping("/all")
    public Set<Employee> getAll()
    {
        return employeeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        boolean employeeExist = false;
        if (id != null)
        {
            employeeExist = true;
        }

        if (employeeExist)
        {
            return employeeService.delete(id);
        }
        else return false;
    }
}
