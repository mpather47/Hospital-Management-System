package com.mpather47.git.factory;

import com.mpather47.git.entity.Account;

public class AccountFactory {
    public static Account createAccount(String accountId, double balance,String paymentMethod){

        return new Account.Builder().setAccountId(accountId).setBalance(balance).setPaymentMethod(paymentMethod).build();
    }

}
