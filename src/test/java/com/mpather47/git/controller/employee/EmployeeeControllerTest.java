package com.mpather47.git.controller.employee;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.factory.employee.EmployeeFactory;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmployeeeControllerTest {

    private static Employee employee = EmployeeFactory.createEmployee("Software Development", Collections.singletonList(""), "Diploma");
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/employee/";

    @Test
    public void a_create()
    {
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + employee);
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee,Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        employee = postResponse.getBody();
        System.out.println("Saved data: " + employee);
        assertEquals(employee.getEmployeeID(),postResponse.getBody().getEmployeeID());
    }

    @Test
    public void b_read()
    {
        String url = baseURL + "read/" + employee.getEmployeeID();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> response = restTemplate.getForEntity(url,Employee.class);

    }

    @Test
    public void c_update()
    {
        Employee updated = new Employee.EmployeeBuilder().copy(employee).setEmployeeID("108566").setEducation("Software Development").setLanguages(Collections.singletonList("")).build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, updated, Employee.class);
        System.out.println(response);
        System.out.println("Updated data: "+ response.getBody());
    }

    @Test
    public void d_getAll() {

        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }

    @Test
    public void e_delete() {

        String url = baseURL + "delete/" + employee.getEmployeeID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}