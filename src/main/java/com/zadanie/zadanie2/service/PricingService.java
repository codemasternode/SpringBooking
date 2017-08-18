package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.exceptions.RecordNotFoundException;
import com.zadanie.zadanie2.model.Pricing;
import com.zadanie.zadanie2.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {
    @Autowired
    private PricingRepository pricingRepository;

    public Pricing insertPricing(Pricing pricing){
        return pricingRepository.save(pricing);
    }

    public List<Pricing> findById(Long id){
        List<Pricing> pricings = pricingRepository.findById(id);
        if(pricings == null){
            throw new RecordNotFoundException("i can't");
        }
        return pricings;
    }
}
