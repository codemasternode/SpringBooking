package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingService {
    @Autowired
    private PricingRepository pricingRepository;
}
