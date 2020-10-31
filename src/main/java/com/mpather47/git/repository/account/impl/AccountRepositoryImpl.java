/**
 package com.mpather47.git.repository.account.impl;

 import com.mpather47.git.entity.account.Account;
 import com.mpather47.git.repository.account.AccountRepository;

 import java.util.HashSet;
 import java.util.Set;

 public class AccountRepositoryImpl implements AccountRepository {

 private static AccountRepository accountRepository = null;
 private Set<Account> accountDB;

 private AccountRepositoryImpl(){ this.accountDB = new HashSet<>(); }

 public static AccountRepository getAccountRepository(){
 if(accountRepository == null) accountRepository = new AccountRepositoryImpl();
 return accountRepository;
 }

 @Override
 public Account create(Account account) {
 this.accountDB.add(account);
 return account;
 }

 @Override
 public Account read(String accountId) {
 Account account = null;
 for(Account s : this.accountDB){
 if(s.getAccountId().equalsIgnoreCase(accountId)){
 account = s;
 break;
 }
 }

 return  account;
 }

 @Override
 public Account update(Account account) {
 Account oldAccDB = read(account.getAccountId());

 if(oldAccDB != null){
 this.accountDB.remove(oldAccDB);
 this.accountDB.add(account);

 }
 return account;
 }

 @Override
 public boolean delete(String accountId) {
 Account account = read(accountId);
 if(account != null) {
 this.accountDB.remove(account);
 return true;
 }
 return false;
 }

 @Override
 public Set<Account> getll() {
 return accountDB;
 }

 }
 **/