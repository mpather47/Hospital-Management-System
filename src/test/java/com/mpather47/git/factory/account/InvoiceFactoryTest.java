package com.mpather47.git.factory.account;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.factory.account.InvoiceFactory;
import org.junit.Assert;

public class InvoiceFactoryTest {

    @org.junit.Test
    public void createInvoice() {

        Invoice invoice = InvoiceFactory.createInvoice(5667);
        Assert.assertEquals(5667, invoice.getInvoiceNum());
    }
}