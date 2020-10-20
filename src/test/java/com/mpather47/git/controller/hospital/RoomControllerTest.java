package com.mpather47.git.controller.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.RoomFactory;
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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomControllerTest {
    static List e;
    static Hospital a;
    private static Room room = RoomFactory.createRoom("2343", e, a);


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/room";

    @Test
    public void a_create(){
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + room);
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, room,Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        room = postResponse.getBody();
        System.out.println("Saved data: " + room);
        assertEquals(room.getRoomId(),postResponse.getBody().getRoomId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + room.getRoomId();
        System.out.println("URL: " + url);
        ResponseEntity<Room> response = restTemplate.getForEntity(url,Room.class);
        assertEquals(room.getRoomId(),response.getBody().getRoomId());
    }

    @Test
    public void c_update(){
        Room updated = new Room.Builder().copy(room).setEquipment(e).setDetails(a).build();
        String url = baseURL + "/update";
        System.out.println("Post data:" + updated);
        ResponseEntity<Room> response = restTemplate.postForEntity(url,updated, Room.class);
        System.out.println(response);
        assertEquals(room.getRoomId(),response.getBody().getRoomId());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "/delete/" + room.getRoomId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_getAll(){
        String url = baseURL + "/all";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }

}

