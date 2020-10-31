package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.factory.account.InvoiceFactory;
import com.mpather47.git.services.account.InvoiceService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceServiceImplTest {

    @Autowired
    private InvoiceService service;
    private static Helper help = new Helper();
    private static Invoice invoice = InvoiceFactory.createInvoice("June 12-2009","Dixion Sound System",AccountFactory.createAccount(3800.76,"Cash"));

    @Test
    public void d_getAll() {

        Set<Invoice> invoices = service.getAll();
        assertEquals(1,invoices.size());
        System.out.println(invoices);
    }

    @Test
    public void a_create() {

        Invoice generate = service.create(invoice);
        assertEquals(invoice.getInvoiceNum(), generate.getInvoiceNum());
        System.out.println("Create: " + generate);
    }

    @Test
    public void b_read() {
        Invoice see = service.read(invoice.getInvoiceNum());
        assertEquals(invoice.getInvoiceNum(), see.getInvoiceNum());
        System.out.println("Read: " + see);
    }

    @Test
    public void c_update() {

        Invoice revise = new Invoice.Builder().copy(invoice).setInvoiceDate("September 14,2019").setDescription("DA 70 USB Headset Adaptor").build();
        revise = service.update(revise);
        Assert.assertEquals(invoice.getInvoiceNum(), revise.getInvoiceNum());
        System.out.println("Update: " + revise);
    }

    @Test
    public void e_delete() {
        service.delete(invoice.getInvoiceNum());
    }
}