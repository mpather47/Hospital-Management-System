package com.mpather47.git.controller.hospital;


import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.factory.hospital.HospitalFactory;
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
public class HospitalControllerTest {
    private static Hospital hospital = HospitalFactory.createHospital("23453", "St Mary", 1254);
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/hospital/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + hospital);
        ResponseEntity<Hospital> postResponse = restTemplate.postForEntity(url,hospital,Hospital.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        hospital = postResponse.getBody();
        System.out.println("Saved data: " + hospital);
        assertEquals(hospital.getHospitalId(),postResponse.getBody().getHospitalId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + hospital.getHospitalId();
        System.out.println("URL: " + url);
        ResponseEntity<Hospital> response = restTemplate.getForEntity(url,Hospital.class);
        assertEquals(hospital.getHospitalId(),response.getBody().getHospitalId());
    }

    @Test
    public void c_update(){
        Hospital updated = new Hospital.Builder().copy(hospital).setHospitalName("st mary").setHospitalNumber(323).build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Hospital> response = restTemplate.postForEntity(url, updated, Hospital.class);
        System.out.println(response);
        assertEquals(updated.getHospitalId(),response.getBody().getHospitalId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + hospital.getHospitalId();
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

