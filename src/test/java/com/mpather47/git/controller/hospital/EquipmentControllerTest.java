package com.mpather47.git.controller.hospital;


import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.EquipmentFactory;
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
public class EquipmentControllerTest {
    private static Room a;
    private static Equipment equipment = EquipmentFactory.createEquipment("232", "Scalpel", "Cutting tool", 5,  a);
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/equipment/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + equipment);
        ResponseEntity<Equipment> postResponse = restTemplate.postForEntity(url, equipment,Equipment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        equipment = postResponse.getBody();
        System.out.println("Saved data: " + equipment);
        assertEquals(equipment.getEquipmentId(),postResponse.getBody().getEquipmentId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + equipment.getEquipmentId();
        System.out.println("URL: " + url);
        ResponseEntity<Equipment> response = restTemplate.getForEntity(url,Equipment.class);
        assertEquals(equipment.getEquipmentId(),response.getBody().getEquipmentId());
    }

    @Test
    public void c_update(){
        Equipment updated = new Equipment.Builder().copy(equipment).setName("knife").setDesc("another cutting tool").setQuantity(3).setDetails(a).build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Equipment> response = restTemplate.postForEntity(url, updated, Equipment.class);
        System.out.println(response);
        assertEquals(equipment.getEquipmentId(),response.getBody().getEquipmentId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + equipment.getEquipmentId();
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


