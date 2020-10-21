package com.mpather47.git.controller.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.factory.account.StatementFactory;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatementControllerTest {

    private Statement statement = StatementFactory.createStatement("10/10/2010",80000.00, AccountFactory.createAccount(7656788.98,"Sale"));
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/statement/";

    @Test
    public void a_create() {
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + statement);
        ResponseEntity<Statement> postResponse = restTemplate.postForEntity(url,statement,Statement.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        statement = postResponse.getBody();
        System.out.println("Saved data: " + statement);
        assertEquals(statement.getStatementNum(),postResponse.getBody().getStatementNum());

    }

    @Test
    public void b_read() {
        String url = baseURL + "read/"+ statement.getStatementNum();
        System.out.println("URL: " + url);
        ResponseEntity<Statement> response = restTemplate.getForEntity(url,Statement.class);
        statement = response.getBody();
        assertEquals(statement.getStatementNum(),response.getBody().getStatementNum());
    }

    @Test
    public void c_update() {
        Statement updated = new Statement.Builder().copy(statement).setDate("14/02/2020").setPaymentDue(67530.00).build();
        String url = baseURL + "update/";
        System.out.println("Post data:" + updated);
        ResponseEntity<Statement> response = restTemplate.postForEntity(url,updated, Statement.class);
        statement = response.getBody();
        System.out.println(statement);
        assertEquals(statement.getStatementNum(),response.getBody().getStatementNum());

    }


    @Test
    public void d_getAll() {
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + statement.getStatementNum();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }
}