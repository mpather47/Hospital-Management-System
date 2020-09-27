package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.utility.Helper;

public class AccountFactory {
    public static Account createAccount( double balance,String paymentMethod){

        String accountId = Helper.generateId();
        return new Account.Builder().
                setAccountId(accountId).
                setBalance(balance).
                setPaymentMethod(paymentMethod)
                .build();
    }

}
