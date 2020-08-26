package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.factory.account.StatementFactory;
import org.junit.Assert;

public class StatementFactoryTest {
// added import for Assert
    @org.junit.Test
    public void createStatement() {
        Statement statement = StatementFactory.createStatement(7);
        Assert.assertEquals(7, statement.getStatementNum());
    }
}