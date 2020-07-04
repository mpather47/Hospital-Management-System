package com.mpather47.git.factory;

import com.mpather47.git.entity.Account;

import static org.junit.Assert.*;

public class AccountFactoryTest {

    @org.junit.Test
    public void createAccount() {
        Account account = AccountFactory.createAccount("154-8768-456",2000.00,"Credit Card");
        Assert.assertNotNull(account);
    }
}