package com.mpather47.git.controller.hospital;

import com.mpather47.git.entity.hospital.Department;
import com.mpather47.git.factory.hospital.DepartmentFactory;
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

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DepartmentControllerTest {

    private static Department department = DepartmentFactory.createDepartment(0,"ICU","Intensive care unit.");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/department/";

    @Test
    public void a_create()
    {
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + department);
        ResponseEntity<Department> postResponse = restTemplate.postForEntity(url, department,Department.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        department = postResponse.getBody();
        System.out.println("Saved data: " + department);
        assertEquals(department.getDepartmentId(),postResponse.getBody().getDepartmentId());

    }
    @Test
    public void b_read()
    {
        String url = baseURL + "read/" + department.getDepartmentId();
        System.out.println("URL: " + url);
        ResponseEntity<Department> response = restTemplate.getForEntity(url,Department.class);
        assertEquals(department.getDepartmentId(),response.getBody().getDepartmentId());
    }
    @Test
    public void c_update()
    {
        Department updated = new Department.DepartmentBuilder().copy(department).setDepartmentId(2451).setWard("ICU").setRole("Intesive care").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Department> response = restTemplate.postForEntity(url, updated, Department.class);
        System.out.println(response);
        //assertEquals(department.getDepartmentId(),response.getBody().getDepartmentId());
    }

    @Test
    public void d_getAll()
    {
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete()
    {
        String url = baseURL + "delete/" + department.getDepartmentId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}