package com.mpather47.git.factory;

import com.mpather47.git.entity.Employee;
import java.util.List;

public class EmployeeFactory {
    public static Employee createEmployee(String education, List<String> languages, String certification){

        return new Employee.EmployeeBuilder().
                setEducation(education).
                setLanguages(languages).
                setCertification(certification).
                build();
    }
}
