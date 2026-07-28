package com.security.java_project.system_design.MyList.inventory.service;

import com.security.java_project.system_design.MyList.inventory.entity.Invoice;

public class InvoiceService {

    public Invoice generateInvoice(
            String invoiceId,
            double amount) {

        return new Invoice(
                invoiceId,
                amount);
    }
}
