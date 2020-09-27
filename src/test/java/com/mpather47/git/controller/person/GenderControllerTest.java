package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.factory.person.GenderFactory;
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
public class GenderControllerTest {

    private static Gender gender = GenderFactory.createGender(1, "Male");

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/gender/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + gender);
        ResponseEntity<Gender> postResponse = restTemplate.postForEntity(url, gender, Gender.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        gender = postResponse.getBody();
        System.out.println("Saved data: " + gender);
        assertEquals(gender.getGenderId(), postResponse.getBody().getGenderId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + gender.getGenderId();
        System.out.println("URL: " + url);
        ResponseEntity<Gender> response = restTemplate.getForEntity(url, Gender.class);
        assertEquals(gender.getGenderType(), response.getBody().getGenderType());
    }

    @Test
    public void c_update() {
        Gender update = new Gender.GenderBuilder().copy(gender).
                setGenderType("Female").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Gender> response = restTemplate.postForEntity(url, update, Gender.class);
        assertNotEquals(gender.getGenderType(), response.getBody().getGenderType());
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
        String url = baseURL + "delete/" + gender.getGenderId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

}