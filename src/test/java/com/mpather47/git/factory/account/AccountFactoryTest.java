package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;

public class AccountFactoryTest {

    @org.junit.Test
    public void createAccount() {

        Helper uuid = new Helper();
        Account account = AccountFactory.createAccount(uuid.generateId(),300.00,"Cash");
        Assert.assertNotNull(account.getAccountId());
        System.out.println(account);
    }
}