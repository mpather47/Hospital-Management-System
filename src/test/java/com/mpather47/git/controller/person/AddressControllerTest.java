package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.AddressFactory;
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
public class AddressControllerTest {
    private static Address address = AddressFactory.addAddress("5454",234234,PersonFactory.createPerson("424234","324324"));
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/address/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + address);
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url,address,Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        address = postResponse.getBody();
        System.out.println("Saved data: " + address);
        assertEquals(address.getAddressId(),postResponse.getBody().getAddressId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" +address.getAddressId();
        System.out.println("URL: " + url);
        ResponseEntity<Address> response = restTemplate.getForEntity(url,Address.class);
        assertEquals(address.getAddressId(),response.getBody().getAddressId());
    }

    @Test
    public void c_update(){
        Address updated = new Address.Builder().copy(address).setPostcode(34234).setAddress("545345").setPostcode(25435543).build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Address> response = restTemplate.postForEntity(url,updated, Address.class);
        System.out.println(response);
        assertEquals(address.getAddressId(),response.getBody().getAddressId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + address.getAddressId();
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
