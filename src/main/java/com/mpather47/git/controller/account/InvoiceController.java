package com.mpather47.git.controller.account;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.factory.account.InvoiceFactory;
import com.mpather47.git.services.account.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice){
        Invoice newInvoice = InvoiceFactory.createInvoice(
                invoice.getInvoiceDate(),
                invoice.getDescription(),
                invoice.getDetails());
        return invoiceService.create(newInvoice);

    }

    @GetMapping("/read{id}")
    public Invoice read(@PathVariable String id){
        return invoiceService.read(id);
    }

    @PostMapping("/update")
    public Invoice update(@RequestBody Invoice invoice){
        return invoiceService.update(invoice);
    }

    @GetMapping("/all")
    public Set<Invoice> getAll(){
        return invoiceService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return invoiceService.delete(id);
    }
}
