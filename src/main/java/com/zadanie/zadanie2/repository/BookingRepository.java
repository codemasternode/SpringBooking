package com.zadanie.zadanie2.repository;

import com.zadanie.zadanie2.model.Booking;
import com.zadanie.zadanie2.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    public List<Booking> findById(Long room);
    public List<Booking> findByGuestName(String guestName);


}
