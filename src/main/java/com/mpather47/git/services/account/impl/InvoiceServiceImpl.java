package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.repository.account.InvoiceRepository;
import com.mpather47.git.repository.account.impl.InvoiceRepositoryImpl;
import com.mpather47.git.services.account.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static InvoiceService invoiceService = null;
    private InvoiceRepository repository;

    private InvoiceServiceImpl(){

        this.repository = InvoiceRepositoryImpl.getInvoiceRepository();
    }

    public static InvoiceService getInvoiceService(){
        if(invoiceService == null) invoiceService = new InvoiceServiceImpl();
        return invoiceService;
    }

    @Override
    public Set<Invoice> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Invoice create(Invoice invoice) {
        return this.repository.create(invoice);
    }

    @Override
    public Invoice read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return this.repository.update(invoice);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
