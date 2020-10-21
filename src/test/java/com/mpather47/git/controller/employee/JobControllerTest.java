package com.mpather47.git.controller.employee;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.employee.JobFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class JobControllerTest {

    private Job job = JobFactory.buildJob("Teacher");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/job";



    @Test
    public void a_create() {


        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + job);
        ResponseEntity<Job> postResponse = restTemplate.postForEntity(url,job,Job.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        job = postResponse.getBody();
        System.out.println("Saved data: " + job);
        assertEquals(job.getJobTittle(),postResponse.getBody().getJobTittle());

    }
    @Test
    public void b_read(){

        String url = baseURL + "read/" + job.getJobTittle();
        System.out.println("URL: " + url);
        ResponseEntity<Job> response = restTemplate.getForEntity(url,Job.class);
        job = response.getBody();
        assertEquals(job.getJobTittle(),response.getBody().getJobTittle());

    }


    @Test
    public void c_update(){

        Job updated = new Job.Builder().copy(job).setjobTittle("Teacher").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Job> response = restTemplate.postForEntity(url,updated, Job.class);
        job = response.getBody();
        System.out.println(job);
        assertEquals(job.getJobTittle(),response.getBody().getJobTittle());
    }

    @Test
    public void d_getall() {
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());


    }
    @Test
    public void e_delete(){

        String url = baseURL + "delete/" + job.getJobTittle()+ job.getJobTittle();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }


}