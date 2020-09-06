package com.mpather47.git.services.account;


import com.mpather47.git.entity.account.Invoice;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface InvoiceService extends IService<Invoice,String> {

    Set<Invoice> getAll();
}
