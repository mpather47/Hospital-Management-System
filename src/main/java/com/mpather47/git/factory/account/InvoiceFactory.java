package com.mpather47.git.factory.account;


import com.mpather47.git.entity.account.Account;
import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.utility.Helper;

public class InvoiceFactory{

    public static Invoice createInvoice(String invoiceDate,String description,Account details){
        String invoiceNum = Helper.generateId();
        return new Invoice.Builder()
                .setInvoiceNum(invoiceNum)
                .setInvoiceDate(invoiceDate)
                .setDescription(description)
                .setDetails(details)
                .build();


    }


}
