package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;

public class AccountFactoryTest {

    @org.junit.Test
    public void createAccount() {

        Account account = AccountFactory.createAccount(300.00,"Cash");
        System.out.println(account);
        Assert.assertNotNull(account);

    }
}