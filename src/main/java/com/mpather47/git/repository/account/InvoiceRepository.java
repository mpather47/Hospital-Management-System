package com.mpather47.git.repository.account;

import com.mpather47.git.entity.account.Invoice;

import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface InvoiceRepository extends IRepository<Invoice, String> {

    Set<Invoice> getAll();
}
