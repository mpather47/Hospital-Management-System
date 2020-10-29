package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.factory.account.StatementFactory;
import com.mpather47.git.services.account.StatementService;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatementServiceImplTest {

    private static StatementService service = StatementServiceImpl.getStatementService();
    private static Helper help = new Helper();
    private static Statement statement = StatementFactory.createStatement("May 04-2017",1600.00,AccountFactory.createAccount(400.00,"Card-payment"));


    @Test
    public void a_create() {
        Statement generate = service.create(statement);
        assertEquals(statement.getStatementNum(), generate.getStatementNum());
        System.out.println("Create: " + generate);
    }

    @Test
    public void b_read() {
        Statement see = service.read(statement.getStatementNum());
        assertEquals(statement.getStatementNum(), see.getStatementNum());
        System.out.println("Read: " + see);
    }

    @Test
    public void c_update() {

        Statement revise = new Statement.Builder().copy(statement).setDate("December 22,2019").setPaymentDue(7800.95).build();
        revise = service.update(revise);
        assertEquals(statement.getStatementNum(), revise.getStatementNum());
        System.out.println("Update: " + revise);
    }

    @Test
    public void d_getAll() {
        Set<Statement> statements = service.getAll();
        assertEquals(1,statements.size());
        System.out.println(statements);
    }

    @Test
    public void e_delete() {
        service.delete(statement.getStatementNum());
    }
}