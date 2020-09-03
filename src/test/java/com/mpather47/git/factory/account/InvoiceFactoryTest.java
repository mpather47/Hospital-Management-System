package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;

public class InvoiceFactoryTest {

    @org.junit.Test
    public void createInvoice() {

        Helper uuid = new Helper();
        Invoice invoice = InvoiceFactory.createInvoice(uuid.generateId(),"April 30-2020","Flat Screen TV",AccountFactory.createAccount(uuid.generateId(),5000.00,"Card-Payment"));
        Assert.assertNotNull(invoice.getInvoiceNum());
        System.out.println(invoice);

    }
}
