package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Statement;

public class StatementFactory {

    public static Statement createStatement(int statementNum){

        return new Statement.Builder().setStatementNum(statementNum).build();
    }
}
