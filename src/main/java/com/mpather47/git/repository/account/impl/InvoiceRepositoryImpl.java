/**
 package com.mpather47.git.repository.account.impl;

 import com.mpather47.git.entity.account.Invoice;
 import com.mpather47.git.repository.account.InvoiceRepository;

 import java.util.HashSet;
 import java.util.Set;

 public class InvoiceRepositoryImpl implements InvoiceRepository {

 private static InvoiceRepository invoiceRepository = null;
 private Set<Invoice> invoiceDB;


 private InvoiceRepositoryImpl(){ this.invoiceDB = new HashSet<>(); }

 public static InvoiceRepository getInvoiceRepository(){
 if(invoiceRepository == null) invoiceRepository = new InvoiceRepositoryImpl();
 return invoiceRepository;
 }


 @Override
 public Invoice create(Invoice invoice) {
 this.invoiceDB.add(invoice);
 return invoice;
 }

 @Override
 public Invoice read(String invoiceNum) {
 Invoice invoice = null;
 for(Invoice i : this.invoiceDB){
 if(i.getInvoiceNum().equalsIgnoreCase(invoiceNum)){
 invoice = i;
 break;
 }
 }

 return  invoice;
 }

 @Override
 public Invoice update(Invoice invoice) {
 Invoice oldinvoiceDB = read(invoice.getInvoiceNum());

 if(oldinvoiceDB != null){
 this.invoiceDB.remove(oldinvoiceDB);
 this.invoiceDB.add(invoice);

 }
 return invoice;
 }

 @Override
 public boolean delete(String invoiceNum) {
 Invoice invoice = read(invoiceNum);
 if(invoice != null) {
 this.invoiceDB.remove(invoice);
 return true;
 }
 return false;
 }

 @Override
 public Set<Invoice> getAll() {
 return invoiceDB;
 }
 }
 **/
