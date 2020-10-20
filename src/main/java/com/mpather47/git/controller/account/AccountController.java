package com.mpather47.git.controller.account;


import com.mpather47.git.entity.account.Account;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.services.account.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    public Account create(@RequestBody Account account){
        Account newAccount = AccountFactory.createAccount(account.getBalance(),
                account.getPaymentMethod());
        return accountService.create(newAccount);
    }
    @GetMapping("/read{id}")
    public Account read( @PathVariable String id){ return accountService.read(id);}

    @PostMapping("/update")
    public Account update(@RequestBody Account account){
        return accountService.update(account);
    }

    @GetMapping("/all")
    public Set<Account> getAll(){
        return accountService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return accountService.delete(id);
    }

}
