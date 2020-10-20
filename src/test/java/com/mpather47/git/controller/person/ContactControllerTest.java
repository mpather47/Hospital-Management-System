package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
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
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactControllerTest {
    private static Contact contact = ContactFactory.addContact(234432,2342434,"4234",PersonFactory.createPerson("Marcel Pather","1241344"));

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
        assertEquals(contact.getContactId(),postResponse.getBody().getContactId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + contact.getContactId();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> response = restTemplate.getForEntity(url,Contact.class);
        assertEquals(contact.getContactId(),response.getBody().getContactId());

    }

    @Test
    public void c_update(){
        Contact updated = new Contact.Builder().copy(contact).setEmail("ggdf").setCellphoneNo(2434324).setHomePhone(23434342).build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Contact> response = restTemplate.postForEntity(url,updated, Contact.class);
        System.out.println(response);
        assertEquals(contact.getContactId(),response.getBody().getContactId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + contact.getContactId();
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
