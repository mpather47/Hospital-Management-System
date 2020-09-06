package com.mpather47.git.services.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface AccountService extends IService<Account, String> {

    Set<Account> getAll();
}
