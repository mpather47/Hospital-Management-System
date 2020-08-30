package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.factory.hospital.DepartmentFactory;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentFactoryTest {

    @Test
    public void createDepartment(){
        Department department = DepartmentFactory.createDepartment(
                1021,
                "The ward",
                "The role");

        Assert.assertNotNull(department);
    }
}