package com.mpather47.git.factory;

import com.mpather47.git.entity.Statement;

import static org.junit.Assert.*;

public class StatementFactoryTest {

    @org.junit.Test
    public void createStatement() {
        Statement statement = StatementFactory.createStatement(7);
        Assert.assertEquals(7, statement.getStatementNum());
    }
}