package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.model.Invoice;
import com.zadanie.zadanie2.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice insertInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }


}
