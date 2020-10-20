package com.mpather47.git.repository.account.impl;

import static org.junit.Assert.*;


import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.factory.account.AccountFactory;
import com.mpather47.git.factory.account.InvoiceFactory;
import com.mpather47.git.repository.account.InvoiceRepository;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvoiceRepositoryImplTest {

    private static InvoiceRepository repository = InvoiceRepositoryImpl.getInvoiceRepository();
    private static Helper help = new Helper();
    private static Invoice invoice = InvoiceFactory.createInvoice("June 12-2009","Dixion Sound System",AccountFactory.createAccount(3800.76,"Cash"));

    @Test
    public void a_create() {

        Invoice generate = repository.create(invoice);
        assertEquals(invoice.getInvoiceNum(), generate.getInvoiceNum());
        System.out.println("Create: " + generate);
    }

    @Test
    public void b_read() {


        Invoice see = repository.read(invoice.getInvoiceNum());
        assertEquals(invoice.getInvoiceNum(), see.getInvoiceNum());
        System.out.println("Read: " + see);

    }


    @Test
    public void c_update() {

        Invoice revise = new Invoice.Builder().copy(invoice).setInvoiceDate("March 14,2020").setDescription("LG Sound System").build();
        revise = repository.update(revise);
        Assert.assertEquals(invoice.getInvoiceNum(), revise.getInvoiceNum());
        System.out.println("Update: " + revise);

    }

    @Test
    public void e_delete() {
        repository.delete(invoice.getInvoiceNum());
    }

    @Test
    public void d_getAll() {
        Set<Invoice> invoices = repository.getAll();
        assertEquals(1,invoices.size());
        System.out.println(repository.getAll());
    }



}