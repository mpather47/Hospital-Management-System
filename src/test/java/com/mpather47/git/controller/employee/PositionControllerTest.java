package com.mpather47.git.controller.employee;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.factory.employee.PositionFactory;
import com.mpather47.git.services.employee.impl.JobServiceImpl;
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

public class PositionControllerTest {

    private Position position= PositionFactory.createPosition("CEO" ,"Accepted");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/position";


    @Test
    public void a_create() {

        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + position);
        ResponseEntity<Position> postResponse = restTemplate.postForEntity(url,position,Position.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        position = postResponse.getBody();
        System.out.println("Saved data: " + position);
        assertEquals(position.getPositionCode(),postResponse.getBody().getPositionStatus());

    }
    @Test
    public void b_read(){


        String url = baseURL + "read/"+position.getPositionCode() + position.getPositionStatus();
        System.out.println("URL: " + url);
        ResponseEntity<Position> response = restTemplate.getForEntity(url,Position.class);
        position = response.getBody();
        assertEquals(position.getPositionCode(),response.getBody().getPositionStatus());


    }


    @Test
    public void c_update(){

        Position updated = new Position.Builder().copy(position).setPositionCode("CEO").setPositionStatus("Accepted").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Position> response = restTemplate.postForEntity(url,updated, Position.class);
        position = response.getBody();
        System.out.println(position);
        assertEquals(position.getPositionCode(),response.getBody().getPositionStatus());
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
        String url = baseURL + "delete/" + position.getPositionCode() +position.getPositionStatus();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}