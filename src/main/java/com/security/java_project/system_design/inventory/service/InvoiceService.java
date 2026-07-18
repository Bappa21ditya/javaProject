package com.security.java_project.system_design.inventory.service;

import com.security.java_project.system_design.inventory.entity.Invoice;

public class InvoiceService {

    public Invoice generateInvoice(
            String invoiceId,
            double amount) {

        return new Invoice(
                invoiceId,
                amount);
    }
}
