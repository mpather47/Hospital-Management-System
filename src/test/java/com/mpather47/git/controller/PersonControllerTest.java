package com.mpather47.git.controller;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.PersonFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonControllerTest {

    private Person person = PersonFactory.createPerson("Marcell","1998/08/21");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/person/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + person);
        ResponseEntity<Person> postResponse = restTemplate.postForEntity(url,person,Person.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        person = postResponse.getBody();
        System.out.println("Saved data: " + person);
        assertEquals(person.getPersonId(),postResponse.getBody().getPersonId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" +person.getPersonId();
        System.out.println("URL: " + url);
        ResponseEntity<Person> response = restTemplate.getForEntity(url,Person.class);
        person = response.getBody();
        assertEquals(person.getPersonId(),response.getBody().getPersonId());
    }

    @Test
    public void c_update(){
        Person updated = new Person.Builder().copy(person).setName("Marvel").setDateOfBirth("1998/08/21").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Person> response = restTemplate.postForEntity(url,updated, Person.class);
        person = response.getBody();
        System.out.println(person);
        assertEquals(person.getPersonId(),response.getBody().getPersonId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + person.getPersonId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }


}
