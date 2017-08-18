package com.zadanie.zadanie2.dto;

import com.zadanie.zadanie2.model.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDTO {
    private Long id;
    private String city;
    private Date dateFrom;
    private Date dateUntil;
    private String guestName;
    private String guestEmail;
    private String guestPhone;

    private List<Booking> bookingList = new ArrayList<>();

    public BookingDTO() {
    }
    public BookingDTO(List<Booking> booking){
       this.bookingList = booking;
    }

    public BookingDTO(Booking booking){
        this.city = booking.getCity();
        this.dateFrom = booking.getDateFrom();
        this.dateUntil = booking.getDateUntil();
        this.guestName = booking.getGuestName();
        this.guestEmail = booking.getGuestEmail();
        this.guestPhone = booking.getGuestPhone();
    }


    public List<Booking> getBookingList() {
        return bookingList;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateUntil() {
        return dateUntil;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public String getGuestPhone() {
        return guestPhone;
    }
}
