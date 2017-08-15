package com.zadanie.zadanie2.service;

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
        return bookingRepository.findAll();
    }
    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking insertBooking(Booking b){
        return bookingRepository.save(b);
    }

    public List<Booking> findByRoomId(Long roomId){
        Room room = roomRepository.findRoomById(roomId);

        return bookingRepository.findByRoom(room);
    }

    public List<Booking> findBookingByGuestName(String guestName){
        return bookingRepository.findByGuestName(guestName);
    }

    public void dropBooking(Long id){
        bookingRepository.delete(id);
    }

}
