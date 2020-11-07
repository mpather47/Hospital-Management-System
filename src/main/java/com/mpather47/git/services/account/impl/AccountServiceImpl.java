package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.repository.account.AccountRepository;
import com.mpather47.git.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Set<Account> getAll() { return this.repository.findAll().stream().collect(Collectors.toSet());

    }

    @Override
    public Account create(Account account) {
        return this.repository.save(account);
    }

    @Override
    public Account read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Account update(Account account) {

        if(this.repository.existsById(account.getAccountId())){
            return this.repository.save(account);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))return false;
        else return true;
    }
}
