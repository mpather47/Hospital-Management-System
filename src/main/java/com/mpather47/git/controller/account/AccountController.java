package com.mpather47.git.controller.account;


import com.mpather47.git.entity.account.Account;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.services.account.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    public Account create(@RequestBody Account account){
        boolean accountExist = false;
        Account newAccount = AccountFactory.createAccount(account.getBalance(), account.getPaymentMethod());
        if(newAccount !=null){
            accountExist = true;
        }
        if (accountExist) {
            return accountService.create(newAccount);
        }
        else  return AccountFactory.createAccount(0.00,"");
    }
    @GetMapping("/read{id}")
    public Account read( @PathVariable String id){
        boolean accountExist = false;
        if (id != null){
            accountExist = true;
        }
        if (accountExist = true) {
            return accountService.read(id);
        }
        else return null;
    }

    @PostMapping("/update")
    public Account update(@RequestBody Account account){
        boolean accountExist = false;
        if(account !=null) {
            accountExist = true;
        }
        if(accountExist) {
            return accountService.update(account);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Account> getAll(){
        return accountService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean accountExist = false;
        if (id != null){
            accountExist = true;
        }
        if (accountExist) {
            return accountService.delete(id);
        }
        else return false;
    }

}
