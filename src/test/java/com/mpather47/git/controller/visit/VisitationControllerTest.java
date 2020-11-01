package com.mpather47.git.controller.visit;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.factory.visit.MedicationFactory;
import com.mpather47.git.factory.visit.VisitationFactory;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisitationControllerTest {
    private static Visitation visitation = VisitationFactory.createVisitation("111","112","113","114","09/05/2020");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/visitation/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.printf("Post data: " + visitation);
        ResponseEntity<Visitation> posResponse = restTemplate.postForEntity(url, visitation, Visitation.class);
        assertNotNull(posResponse);
        assertNotNull(posResponse.getBody());
        visitation = posResponse.getBody();
        System.out.println("Saved data: " + visitation);
        assertEquals(visitation.getVisitId(),posResponse.getBody().getVisitId());
    }

    @Test
    public void b_read() {
        String url = baseURL +  "read/" + visitation.getVisitId();
        System.out.println("URL: " + url);
        ResponseEntity<Visitation> response = restTemplate.getForEntity(url,Visitation.class);
        assertEquals(visitation.getVisitId(),response.getBody().getVisitId());
    }

    @Test
    public void c_update() {
        Visitation updated = new Visitation.Builder().copyVisitation(visitation).setVisitId("123").setPatientId("124").setDoctorId("125").setPrescriptionId("126").setVisitDate("07/06/2020").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Visitation> response = restTemplate.postForEntity(url,updated, Visitation.class);
        System.out.println(response);
        assertEquals(visitation.getVisitId(),response.getBody().getVisitId());
    }

    @Test
    public void d_delete() {
        String url = baseURL + "delete/" + visitation.getVisitId();
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