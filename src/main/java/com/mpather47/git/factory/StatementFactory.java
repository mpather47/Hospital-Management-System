package com.mpather47.git.factory;

import com.mpather47.git.entity.Statement;

public class StatementFactory {

    public static Statement createStatement(int statementNum){

        return new Statement.Builder().setStatementNum(statementNum).build();
    }
}
