package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.entity.account.Statement;

public class StatementFactory {

    public static Statement createStatement(String statementNum, String date, double paymentDue, Account details){

        return new Statement.Builder()
                .setStatementNum(statementNum)
                .setDate(date)
                .setPaymentDue(paymentDue)
                .setDetails(details)
                .build();

    }
}
