
/**
 package com.mpather47.git.repository.account.impl;


 import com.mpather47.git.entity.account.Account;
 import com.mpather47.git.factory.account.AccountFactory;
 import com.mpather47.git.repository.account.AccountRepository;
 import com.mpather47.git.repository.account.impl.AccountRepositoryImpl;
 import com.mpather47.git.utility.Helper;
 import org.junit.Assert;
 import org.junit.FixMethodOrder;
 import org.junit.Test;
 import org.junit.runners.MethodSorters;

 import java.util.Set;

 import static org.junit.Assert.*;
 @FixMethodOrder(MethodSorters.NAME_ASCENDING)
 public class AccountRepositoryImplTest {

 private static AccountRepository repository = AccountRepositoryImpl.getAccountRepository();
 private static Helper help = new Helper();
 private static Account account = AccountFactory.createAccount(2700.00,"Credit_payement");


 @Test
 public void a_create() {

 Account generate = repository.create(account);
 assertEquals(account.getAccountId(), generate.getAccountId());
 System.out.println("Create: " + generate);
 }

 @Test
 public void b_read() {


 Account see = repository.read(account.getAccountId());
 assertEquals(account.getAccountId(), see.getAccountId());
 System.out.println("Read: " + see);

 }

 @Test
 public void c_update() {

 Account revise = new Account.Builder().copy(account).setBalance(100000.00).setPaymentMethod("Cash").build();
 revise = repository.update(revise);
 Assert.assertEquals(account.getAccountId(), revise.getAccountId());
 System.out.println("Update: " + revise);

 }

 @Test
 public void e_delete() {
 repository.delete(account.getAccountId());
 }

 @Test
 public void d_getAll() {
 Set<Account> accounts = repository.getll();
 assertEquals(1,((Set) accounts).size());
 System.out.println(repository.getll());
 }

 }
 **/