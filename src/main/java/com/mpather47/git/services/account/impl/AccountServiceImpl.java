package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.repository.account.AccountRepository;
import com.mpather47.git.repository.account.impl.AccountRepositoryImpl;
import com.mpather47.git.services.account.AccountService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AccountServiceImpl implements AccountService {

    private static AccountService accountService = null;
    private AccountRepository repository;

    private AccountServiceImpl(){

        this.repository = AccountRepositoryImpl.getAccountRepository();
    }

    public static AccountService getAccountService(){
        if(accountService == null) accountService = new AccountServiceImpl();
        return accountService;
    }
    @Override
    public Set<Account> getAll() {

        return this.repository.getll();
    }

    @Override
    public Account create(Account account) {
        return this.repository.create(account);
    }

    @Override
    public Account read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Account update(Account account) {
        return this.repository.update(account);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
