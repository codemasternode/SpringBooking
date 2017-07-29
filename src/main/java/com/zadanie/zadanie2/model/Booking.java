package com.zadanie.zadanie2.model;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String until;
    private String guestName;
    private String guestEmail;
    private String guestPhone;
    @OneToOne(cascade = CascadeType.ALL)
    private Invoice invoice;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;


    public Booking() {
    }

    public Booking(String city, String until, String guestName, String guestEmail, String guestPhone, Invoice invoice,Room room) {
        this.city = city;
        this.until = until;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.guestPhone = guestPhone;
        this.invoice = invoice;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }


}
