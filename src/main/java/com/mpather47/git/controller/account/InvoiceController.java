package com.mpather47.git.controller.account;

import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.factory.account.InvoiceFactory;
import com.mpather47.git.services.account.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceServiceImpl invoiceService;

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice){
        boolean invoiceExist = false;
        Invoice newInvoice = InvoiceFactory.createInvoice(invoice.getInvoiceDate(), invoice.getDescription(), invoice.getDetails());
        if (newInvoice != null) {
            invoiceExist = true;
        }
        if (invoiceExist) {
            return invoiceService.create(newInvoice);
        }
        else return InvoiceFactory.createInvoice(null,null,null);
    }

    @GetMapping("/read{id}")
    public Invoice read(@PathVariable String id){
        boolean invoiceExist = false;
        if(id !=null){
            invoiceExist = true;
        }
        if (invoiceExist = true) {
            return invoiceService.read(id);
        }
        else return null;
    }

    @PostMapping("/update")
    public Invoice update(@RequestBody Invoice invoice){
        boolean invoiceExist = false;
        if(invoice !=null) {
            invoiceExist = true;
        }
        if (invoiceExist) {
            return invoiceService.update(invoice);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Invoice> getAll(){
        return invoiceService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean invoiceExist = false;
        if(id != null){
            invoiceExist = true;
        }
        if (invoiceExist) {
            return invoiceService.delete(id);
        }
        else return false;
    }
}
