package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;


public class StatementFactoryTest {

    @org.junit.Test
    public void createStatement() {
        Helper uuid = new Helper();
        Statement statement = StatementFactory.createStatement(uuid.generateId(),"12/24/2020",5000.00,AccountFactory.createAccount(uuid.generateId(),300.00,"Cash"));
        Assert.assertNotNull(statement.getStatementNum());
        System.out.println(statement);


    }
}