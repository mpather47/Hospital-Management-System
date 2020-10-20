package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;

public class InvoiceFactoryTest {

    @org.junit.Test
    public void createInvoice() {

        Invoice invoice = InvoiceFactory.createInvoice("April 30-2020","Flat Screen TV",AccountFactory.createAccount(5000.00,"Card-Payment"));
        Assert.assertNotNull(invoice.getInvoiceNum());
        System.out.println(invoice);

    }
}
