package com.mpather47.git.controller.visit;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.factory.visit.MedicationFactory;
import com.mpather47.git.factory.visit.PrescriptionFactory;
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
public class PrescriptionControllerTest {

    private static Prescription prescription = PrescriptionFactory.createPrescription("1231","123123","123123");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/prescription/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.printf("Post data: " + prescription);
        ResponseEntity<Prescription> posResponse = restTemplate.postForEntity(url, prescription, Prescription.class);
        assertNotNull(posResponse);
        assertNotNull(posResponse.getBody());
        prescription = posResponse.getBody();
        System.out.println("Saved data: " + prescription);
        assertEquals(prescription.getMedicationId(),posResponse.getBody().getMedicationId());
    }

    @Test
    public void b_read() {
        String url = baseURL +  "read/" + prescription.getPrescriptionId();
        System.out.println("URL: " + url);
        ResponseEntity<Prescription> response = restTemplate.getForEntity(url,Prescription.class);
        assertEquals(prescription.getPrescriptionId(),response.getBody().getPrescriptionId());
    }

    @Test
    public void c_update() {
        Prescription updated = new Prescription.Builder().copyPrescription(prescription).setPrescriptionId("1111").setMedicationId("22222").setVisitId("3333").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Prescription> response = restTemplate.postForEntity(url,updated, Prescription.class);
        System.out.println(response);
        assertEquals(prescription.getPrescriptionId(),response.getBody().getPrescriptionId());
    }

    @Test
    public void d_delete() {
        String url = baseURL + "delete/" +prescription.getPrescriptionId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void e_getAll() {
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }


}