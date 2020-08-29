package com.mpather47.git.factory.account;


import com.mpather47.git.entity.account.Invoice;

public class InvoiceFactory{

    public static Invoice createInvoice(long invoiceNum){

        return new Invoice.Builder().setInvoiceNum(invoiceNum).build();
    }
}
