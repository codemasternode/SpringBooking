package com.zadanie.zadanie2.controler;


import com.zadanie.zadanie2.model.Booking;
import com.zadanie.zadanie2.model.Room;
import com.zadanie.zadanie2.model.RoomCategory;
import com.zadanie.zadanie2.service.BookingService;
import com.zadanie.zadanie2.service.RoomCategoryService;
import com.zadanie.zadanie2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestController1 {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomCategoryService roomCategoryService;

    @RequestMapping(value = "/booking",method = RequestMethod.GET)
    public List<Booking> findAllBooking(){
        return bookingService.findAllBooking();
    }

    @RequestMapping(value = "/rooms",method = RequestMethod.GET)
    public List<Room> findAllRoom(){
        return roomService.findAll();
    }

    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public List<RoomCategory> findAllCategories(){
        return roomCategoryService.findAll();
    }

}

