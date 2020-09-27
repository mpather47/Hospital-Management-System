package com.mpather47.git.controller.appointment;

import com.mpather47.git.entity.appointment.Appointment;
import com.mpather47.git.factory.appointment.AppointmentFactory;
import com.mpather47.git.utility.Helper;
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

import java.time.LocalDate;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentControllerTest {

    private static Appointment appointment = AppointmentFactory.createAppointment(new Helper().generateId(),"3", LocalDate.of(2020,10,20));

    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/appointment/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + appointment);
        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(url, appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        appointment = postResponse.getBody();
        System.out.println("Saved data: " + appointment);
        assertEquals(appointment.getAppointmentId(), postResponse.getBody().getAppointmentId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + appointment.getAppointmentId();
        System.out.println("URL: " + url);
        ResponseEntity<Appointment> response = restTemplate.getForEntity(url, Appointment.class);
        assertEquals(appointment.getAppointmentId(), response.getBody().getAppointmentId());
    }

    @Test
    public void c_update() {
        Appointment update = new Appointment.AppointmentBuilder().copy(appointment).
                setBookingDate(LocalDate.of(2020,11,3)).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Appointment> response = restTemplate.postForEntity(url, update, Appointment.class);
        assertNotEquals(appointment.getBookingDate(), response.getBody().getBookingDate());
    }

    @Test
    public void d_list() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + appointment.getAppointmentId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

}