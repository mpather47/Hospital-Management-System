package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Department;

public class DepartmentFactory {
    public static Department createDepartment(int departmentID, String ward, String role){
        Department department = new Department.DepartmentBuilder().
                setDepartmentId(departmentID).
                setWard(ward).
                setRole(role).build();

        return department;
    }
}
