package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.exceptions.RecordNotFoundException;
import com.zadanie.zadanie2.model.Booking;
import com.zadanie.zadanie2.model.Room;
import com.zadanie.zadanie2.repository.BookingRepository;
import com.zadanie.zadanie2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Booking> findAllBooking(){
        List<Booking> bookings = bookingRepository.findAll();
        if(bookings.isEmpty()){
            throw new RecordNotFoundException("You are too poor to have reservations");
        }
        return bookings;
    }
    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking insertBooking(Booking b){
        return bookingRepository.save(b);
    }

    public List<Booking> findByRoomId(Long roomId){
        List<Booking> bookings = bookingRepository.findById(roomId);
        if(bookings.isEmpty()){
            throw new RecordNotFoundException("Don't found any bookings on this room");
        }
        return bookings;
    }

    public List<Booking> findBookingByGuestName(String guestName){
        List<Booking> bookings = bookingRepository.findByGuestName(guestName);
        if(bookings.isEmpty()){
            throw new RecordNotFoundException("Don't found booking for this guestName");
        }
        return bookings;
    }

    public List<Booking> findByBookingId(Long id){
        List<Booking> bookings = bookingRepository.findById(id);
        if(bookings.isEmpty()){
            throw new RecordNotFoundException("This booking doesn't exist");
        }
        return bookings;
    }

    public void dropBooking(Long id){
        List<Booking> bookings = bookingRepository.findById(id);
        if(bookings.isEmpty()){
            throw new RecordNotFoundException("This booking doesn't exist");
        }
        bookingRepository.delete(id);

    }

}
