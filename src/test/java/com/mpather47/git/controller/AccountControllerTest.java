package com.mpather47.git.controller;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.factory.account.AccountFactory;
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
class AccountControllerTest {

    private static Account account = AccountFactory.createAccount(500.0,"cash");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/account/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + account);
        ResponseEntity<Account> postResponse = restTemplate.postForEntity(url,account,Account.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        account = postResponse.getBody();
        System.out.println("Saved data: " + account);
        assertEquals(account.getAccountId(),postResponse.getBody().getAccountId());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + account.getAccountId();
        System.out.println("URL: " + url);
        ResponseEntity<Account> response = restTemplate.getForEntity(url,Account.class);
        assertEquals(account.getAccountId(),response.getBody().getAccountId());


    }

    @Test
    public void c_update(){
        Account updated = new Account.Builder().copy(account).setBalance(2500.00).setPaymentMethod("Card payment").build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Account> response = restTemplate.postForEntity(url,updated, Account.class);
        System.out.println(response);
        assertEquals(updated.getAccountId(),response.getBody().getAccountId());


    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + account.getAccountId();
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