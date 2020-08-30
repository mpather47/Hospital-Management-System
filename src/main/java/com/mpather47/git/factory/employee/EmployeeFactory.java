package com.mpather47.git.factory.employee;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.utility.Helper;

import java.util.List;

public class EmployeeFactory {
    public static Employee createEmployee(String education, List<String> languages, String certification){

        return new Employee.EmployeeBuilder().
                setEmployeeID(new Helper().generateId()).
                setEducation(education).
                setLanguages(languages).
                setCertification(certification).
                build();
    }
}
