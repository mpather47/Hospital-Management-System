package com.mpather47.git.controller;


import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.factory.account.InvoiceFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class InvoiceControllerTest {

    private static Invoice invoice = InvoiceFactory.createInvoice("27/07/2023","Coka Cola", AccountFactory.createAccount(555.00,"Payroll"));
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/invoice/";


    @Test
    void a_create() {
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + invoice);
        ResponseEntity<Invoice> postResponse = restTemplate.postForEntity(url,invoice,Invoice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        invoice = postResponse.getBody();
        System.out.println("Saved data: " + invoice);
        assertEquals(invoice.getInvoiceNum(),postResponse.getBody().getInvoiceNum());


    }

    @Test
    void b_read() {
        String url = baseURL + "read/" + invoice.getInvoiceNum();
        System.out.println("URL: " + url);
        ResponseEntity<Invoice> response = restTemplate.getForEntity(url,Invoice.class);
        assertEquals(invoice.getInvoiceNum(),response.getBody().getInvoiceNum());



    }

    @Test
    void c_update() {
        Invoice updated = new Invoice.Builder().copy(invoice).setInvoiceDate("07/01/2021").setDescription("LG Refrigerant").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Invoice> response = restTemplate.postForEntity(url,updated, Invoice.class);
        System.out.println(response);
        assertEquals(invoice.getInvoiceNum(),response.getBody().getInvoiceNum());

    }

    @Test
    void e_delete() {
        String url = baseURL + "delete/" + invoice.getInvoiceNum();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }


}