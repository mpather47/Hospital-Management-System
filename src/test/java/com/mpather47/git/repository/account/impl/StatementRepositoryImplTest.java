package com.mpather47.git.repository.account.impl;


import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.factory.account.StatementFactory;
import com.mpather47.git.repository.account.StatementRepository;
import com.mpather47.git.utility.Helper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatementRepositoryImplTest {


    private static StatementRepository repository = StatementRepositoryImpl.getStatementRepository();
    private static Helper help = new Helper();

    private static Statement statement = StatementFactory.createStatement("October 04-2012",8790.98,AccountFactory.createAccount(15000.00,"Debit-order"));

    @Test
    public void a_create() {

        Statement generate = repository.create(statement);
        assertEquals(statement.getStatementNum(), generate.getStatementNum());
        System.out.println("Create: " + generate);

    }

    @Test
    public void b_read() {

        Statement see = repository.read(statement.getStatementNum());
        assertEquals(statement.getStatementNum(), see.getStatementNum());
        System.out.println("Read: " + see);
    }

    @Test
    public void c_update() {

        Statement revise = new Statement.Builder().copy(statement).setDate("October 22,2013").setPaymentDue(5500.95).build();
        revise = repository.update(revise);
        assertEquals(statement.getStatementNum(), revise.getStatementNum());
        System.out.println("Update: " + revise);
    }

    @Test
    public void e_delete() {
        repository.delete(statement.getStatementNum());

    }

    @Test
    public void d_getAll() {
        Set<Statement> statements = repository.getAll();
        assertEquals(1,statements.size());
        System.out.println(repository.getAll());
    }
}