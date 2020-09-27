package com.mpather47.git.controller.hospital;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.factory.hospital.WardFactory;
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
public class WardControllerTest {

    private static Ward ward = WardFactory.createWard(9, 5);

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/ward/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + ward);
        ResponseEntity<Ward> postResponse = restTemplate.postForEntity(url, ward, Ward.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ward = postResponse.getBody();
        System.out.println("Saved data: " + ward);
        assertEquals(ward.getWardId(), postResponse.getBody().getWardId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + ward.getWardId();
        System.out.println("URL: " + url);
        ResponseEntity<Ward> response = restTemplate.getForEntity(url, Ward.class);
        assertEquals(ward.getWardId(), response.getBody().getWardId());
    }

    @Test
    public void c_update() {
        Ward update = new Ward.WardBuilder().copy(ward).setWardSize(23).build();

        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Ward> response = restTemplate.postForEntity(url, update, Ward.class);
        assertNotEquals(ward.getWardSize(), response.getBody().getWardSize());
    }

    @Test
    public void d_list() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + ward.getWardId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}