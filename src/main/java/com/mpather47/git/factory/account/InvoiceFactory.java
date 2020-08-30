package com.mpather47.git.factory.account;


import com.mpather47.git.entity.account.Account;
import com.mpather47.git.entity.account.Invoice;



public class InvoiceFactory{

    public static Invoice createInvoice(String invoiceNum,String invoiceDate,String description,Account details){

        return new Invoice.Builder()
                .setInvoiceNum(invoiceNum)
                .setInvoiceDate(invoiceDate)
                .setDescription(description)
                .setDetails(details)
                .build();


    }


}
