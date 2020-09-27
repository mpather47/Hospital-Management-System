package com.mpather47.git.controller.visit;


import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.factory.visit.MedicationFactory;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MedicationControllerTest {
    private static Medication medication = MedicationFactory.createMedication("1111", "11231","1312");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/medication/";

    @Test
    public void a_create(){
        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.printf("Post data: " + medication);
        ResponseEntity<Medication> posResponse = restTemplate.postForEntity(url, medication, Medication.class);
        assertNotNull(posResponse);
        assertNotNull(posResponse.getBody());
        medication = posResponse.getBody();
        System.out.println("Saved data: " + medication);
        assertEquals(medication.getMedicationId(),posResponse.getBody().getMedicationId());
    }

    @Test
    public void b_read(){
        String url = baseURL +  "read/" + medication.getMedicationId();
        System.out.println("URL: " + url);
        ResponseEntity<Medication> response = restTemplate.getForEntity(url,Medication.class);
        assertEquals(medication.getMedicationId(),response.getBody().getMedicationId());
    }

    @Test
    public void c_update(){
        Medication updated = new Medication.Builder().copyMedication(medication).setMedicationId("1242").setVisit("121").setPrescriptionId("123123").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Medication> response = restTemplate.postForEntity(url,updated, Medication.class);
        System.out.println(response);
        assertEquals(medication.getMedicationId(),response.getBody().getMedicationId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + medication.getMedicationId();
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