package com.zadanie.zadanie2.model;

import javax.persistence.*;

@Entity
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double priceGuest1;
    private double priceGuest2;
    private double priceGuest3;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_category_id")
    private RoomCategory roomCategory;

    public Pricing() {
    }

    public Pricing(double priceGuest1, double priceGuest2, double priceGuest3) {
        this.priceGuest1 = priceGuest1;
        this.priceGuest2 = priceGuest2;
        this.priceGuest3 = priceGuest3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPriceGuest1() {
        return priceGuest1;
    }

    public void setPriceGuest1(double priceGuest1) {
        this.priceGuest1 = priceGuest1;
    }

    public double getPriceGuest2() {
        return priceGuest2;
    }

    public void setPriceGuest2(double priceGuest2) {
        this.priceGuest2 = priceGuest2;
    }

    public double getPriceGuest3() {
        return priceGuest3;
    }

    public void setPriceGuest3(double priceGuest3) {
        this.priceGuest3 = priceGuest3;
    }
}
