package com.mpather47.git.controller.hospital;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.factory.hospital.DepartmentFactory;
import com.mpather47.git.services.hospital.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Set;
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping("/create")
    public Department create(@RequestBody Department department) {
        boolean departmentExist = false;
        Department newDepartment = DepartmentFactory.createDepartment(department.getDepartmentId(),department.getWard(),department.getRole());
        if (newDepartment != null) {
            departmentExist = true;
        }
        if (departmentExist) {
            return departmentService.create(newDepartment);
        }
        else
            return DepartmentFactory.createDepartment(0, null, null);
    }
    @GetMapping("/read/{id}")
    public Department read(@PathVariable String id) {
        boolean departmentExist = false;
        if (id != null) {
            departmentExist = true;
        }

        if (departmentExist) {
            return departmentService.read(0);
        }
        else
            return null;
    }
    @PostMapping("/update")
    public Department update(@RequestBody Department department) {
        boolean departmentExist = false;
        if (department != null) {
            departmentExist = true;
        }

        if (departmentExist) {
            return departmentService.update(department);
        }
        else return null;
    }
    @GetMapping("/all")
    public Set<Department> getAll() {
        return departmentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        boolean departmentExist = false;
        if (id != null) {
            departmentExist = true;
        }

        if (departmentExist) {
            return departmentService.delete(0);
        }
        else return false;
    }
}
