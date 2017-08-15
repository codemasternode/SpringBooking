package com.zadanie.zadanie2.controler;


import com.zadanie.zadanie2.model.Booking;
import com.zadanie.zadanie2.model.Pricing;
import com.zadanie.zadanie2.model.Room;
import com.zadanie.zadanie2.model.RoomCategory;
import com.zadanie.zadanie2.service.BookingService;
import com.zadanie.zadanie2.service.PricingService;
import com.zadanie.zadanie2.service.RoomCategoryService;
import com.zadanie.zadanie2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/api")
public class RESTController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomCategoryService roomCategoryService;
    @Autowired
    private PricingService pricingService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public List<Booking> findAllBooking(){
        return bookingService.findAllBooking();
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> findAllRoom(){
        return roomService.findAll();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<RoomCategory> findAllCategories(){
        return roomCategoryService.findAll();
    }

    @RequestMapping(value = "/reservation/{room}", method = RequestMethod.GET)
    public List<Booking> findReservationById(@PathVariable(value = "room") Long id){
        return bookingService.findByRoomId(id);
    }

    @RequestMapping(value ="/reservationName/{name}", method = RequestMethod.GET)
    public List<Booking> findBookingByGuestName(@PathVariable String name){
        return bookingService.findBookingByGuestName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public RoomCategory insertCategory(@RequestBody RoomCategory roomCategory){
        return roomCategoryService.insertRoomCategory(roomCategory);
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public Room insertRoom(@RequestBody Room room){
        return roomService.insertRoom(room);
    }

    @RequestMapping(value = "/booking",method = RequestMethod.POST)
    public Booking insertBooking(@RequestBody Booking booking){
        return bookingService.insertBooking(booking);
    }

    @RequestMapping(value = "/roomDrop/{room}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable(value = "room")Long id){
        roomService.dropRoom(id);
    }

    @RequestMapping(value = "/roomUpdate", method = RequestMethod.PUT)
    public Room updateRoom(@RequestBody Room room){
        return roomService.updateData(room);
    }

    @RequestMapping(value = "/categoryUpdate", method = RequestMethod.PUT)
    public RoomCategory updateCategory(@RequestBody RoomCategory roomCategory){
        return roomCategoryService.insertRoomCategory(roomCategory);
    }

    @RequestMapping(value = "/bookingUpdate", method = RequestMethod.PUT)
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.insertBooking(booking);
    }

    @RequestMapping(value = "/pricingUpdate", method = RequestMethod.PUT)
    public Pricing updatePricing(@RequestBody Pricing pricing){
        return pricingService.insertPricing(pricing);
    }

    @RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.DELETE)
    public void deleteBooking(@PathVariable Long id){
         bookingService.dropBooking(id);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    public Room findRoomById(@PathVariable Long id){
        return roomService.findRoomById(id);
    }

    @RequestMapping(value = "/deleteRoomCategory/{id}",method = RequestMethod.DELETE)
    public void deleteRoomCategory(@PathVariable(value = "id")Long id){
        roomCategoryService.dropRoomCategory(id);
    }


}

