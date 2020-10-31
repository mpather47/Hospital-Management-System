package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.repository.account.InvoiceRepository;
import com.mpather47.git.services.account.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;


    @Override
    public Set<Invoice> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Invoice create(Invoice invoice) { return this.repository.save(invoice);
    }

    @Override
    public Invoice read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Invoice update(Invoice invoice) {
        if(this.repository.existsById(invoice.getInvoiceNum())){
            return this.repository.save(invoice);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))return false;
        else return true;
    }
}
