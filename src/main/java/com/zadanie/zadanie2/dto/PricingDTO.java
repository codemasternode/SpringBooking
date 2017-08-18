package com.zadanie.zadanie2.dto;

import com.zadanie.zadanie2.model.Pricing;
import com.zadanie.zadanie2.model.RoomCategory;

import java.util.ArrayList;
import java.util.List;

public class PricingDTO {
    private Long id;
    private double priceGuest1;
    private double priceGuest2;
    private double priceGuest3;
    private Long roomCategoryId;
    private List<Pricing> pricings = new ArrayList<>();


    public PricingDTO() {
    }

    public PricingDTO(List<Pricing> pricings){
        this.pricings = pricings;
    }

    public Long getId() {
        return id;
    }

    public double getPriceGuest1() {
        return priceGuest1;
    }

    public double getPriceGuest2() {
        return priceGuest2;
    }

    public double getPriceGuest3() {
        return priceGuest3;
    }

    public Long getRoomCategoryId() {
        return roomCategoryId;
    }
}
