package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.utility.Helper;

public class StatementFactory {

    public static Statement createStatement( String date, double paymentDue, Account details){

        String statementNum = Helper.generateId();
        return new Statement.Builder()
                .setStatementNum(statementNum)
                .setDate(date)
                .setPaymentDue(paymentDue)
                .setDetails(details)
                .build();

    }
}
