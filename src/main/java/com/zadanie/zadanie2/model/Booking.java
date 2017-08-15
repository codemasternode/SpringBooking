package com.zadanie.zadanie2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private Date dateFrom;
    private Date dateUntil;
    private String guestName;
    private String guestEmail;
    private String guestPhone;

    @OneToOne(cascade = CascadeType.ALL)
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Room room;

    public Booking() {
    }

    public Booking(String city, Date dateFrom, Date dateUntil, String guestName, String guestEmail, String guestPhone, Invoice invoice, Room room) {
        this.city = city;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(Date dateUntil) {
        this.dateUntil = dateUntil;
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
