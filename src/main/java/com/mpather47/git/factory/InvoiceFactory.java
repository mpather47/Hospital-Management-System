package com.mpather47.git.factory;


import com.mpather47.git.entity.Invoice;

public class InvoiceFactory{

    public static Invoice createInvoice(long invoiceNum){

        return new Invoice.Builder().setInvoiceNum(invoiceNum).build();
    }
}
