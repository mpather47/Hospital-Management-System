package com.mpather47.git.factory;

import com.mpather47.git.entity.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeFactoryTest {
    @Test
    public void createEmployee(){

        Employee employee = EmployeeFactory.createEmployee("ND",
                new ArrayList<>(Arrays.asList("Xhosa","English"))
                , "ND IT");

        Assert.assertNotNull(employee);
    }
}