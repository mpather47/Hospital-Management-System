package com.mpather47.git.controller;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.person.ContactFactory;
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
public class ContactControllerTest {
    private Contact contact = ContactFactory.addContact(234432,2342434,"4234",PersonFactory.createPerson("Marcel Pather","1241344"));

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/contact/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + contact);
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url,contact,Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        contact = postResponse.getBody();
        System.out.println("Saved data: " + contact);
        assertEquals(contact.getDetails().getPersonId(),postResponse.getBody().getDetails().getPersonId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/"+contact.getDetails().getPersonId();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> response = restTemplate.getForEntity(url,Contact.class);
        contact = response.getBody();
        assertEquals(contact.getDetails().getPersonId(),response.getBody().getDetails().getPersonId());
    }

    @Test
    public void c_update(){
        Contact updated = new Contact.Builder().copy(contact).setCellphoneNo(235253).setHomePhone(453454).setEmail("gsggfdgdf").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Contact> response = restTemplate.postForEntity(url,updated, Contact.class);
        contact = response.getBody();
        System.out.println(contact);
        assertEquals(contact.getDetails().getPersonId(),response.getBody().getDetails().getPersonId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + contact.getDetails().getPersonId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }

}
