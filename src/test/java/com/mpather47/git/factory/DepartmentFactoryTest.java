package com.mpather47.git.factory;

import com.mpather47.git.entity.Department;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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