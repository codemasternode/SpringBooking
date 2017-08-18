package com.zadanie.zadanie2.controler;


import com.zadanie.zadanie2.dto.BookingDTO;
import com.zadanie.zadanie2.dto.PricingDTO;
import com.zadanie.zadanie2.dto.RoomCategoryDTO;
import com.zadanie.zadanie2.exceptions.RecordNotFoundException;
import com.zadanie.zadanie2.helpers.ApiResponse;
import com.zadanie.zadanie2.helpers.ApiResponse.Status;
import com.zadanie.zadanie2.helpers.ApiResponse.ApiError;
import com.zadanie.zadanie2.dto.RoomDTO;
import com.zadanie.zadanie2.model.Booking;
import com.zadanie.zadanie2.model.Pricing;
import com.zadanie.zadanie2.model.Room;
import com.zadanie.zadanie2.model.RoomCategory;
import com.zadanie.zadanie2.service.BookingService;
import com.zadanie.zadanie2.service.PricingService;
import com.zadanie.zadanie2.service.RoomCategoryService;
import com.zadanie.zadanie2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ApiResponse findAllBooking(){
        try{
            List<Booking> bookings = bookingService.findAllBooking();
            return new ApiResponse(Status.OK,new BookingDTO(bookings),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(302,"Don't found any bookings, you are too poor"));
        }
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ApiResponse findAllRoom(){
        try{
            List<Room> rooms = roomService.findAll();
            return new ApiResponse(Status.OK,new RoomDTO(rooms),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null, new ApiError(902,"Too poor to have rooms"));
        }
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ApiResponse findAllCategories(){
        try {
            List<RoomCategory> roomCategories = roomCategoryService.findAll();
            return new ApiResponse(Status.OK,new RoomCategoryDTO(roomCategories),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"Don't found any categories"));
        }
    }

    @RequestMapping(value = "/reservation/{room}", method = RequestMethod.GET)
    public ApiResponse findReservationById(@PathVariable(value = "room") Long id){
        try {
            List<Booking> bookings = bookingService.findByRoomId(id);
            return new ApiResponse(Status.OK, new BookingDTO(bookings),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"Don't found any booking on this room: " + id));
        }
    }

    @RequestMapping(value ="/reservationName/{name}", method = RequestMethod.GET)
    public ApiResponse findBookingByGuestName(@PathVariable String name){
        try{
            List<Booking> bookings = bookingService.findBookingByGuestName(name);
            return new ApiResponse(Status.OK,new BookingDTO(bookings),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null, new ApiError(777,"don't found guest for this name:" + name));
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public RoomCategory insertCategory(@RequestBody RoomCategory roomCategory){
        return roomCategoryService.insertRoomCategory(roomCategory);
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ApiResponse insertRoom(@RequestBody Room room){
        Room room1 = roomService.insertRoom(room);
        return new ApiResponse(Status.OK, null);
    }

    @RequestMapping(value = "/booking",method = RequestMethod.POST)
    public Booking insertBooking(@RequestBody Booking booking){
        return bookingService.insertBooking(booking);
    }

    @RequestMapping(value = "/roomDrop/{room}", method = RequestMethod.DELETE)
    public ApiResponse deleteRoom(@PathVariable(value = "room")Long id){
        try{
            roomService.dropRoom(id);
            return new ApiResponse(Status.OK,null,null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null, new ApiError(404,"Don't found room by id: " + id));
        }catch (DataIntegrityViolationException ex){
            return new ApiResponse(Status.ERROR, null, new ApiError(500, "This room has reservation"));
        }
    }

    @RequestMapping(value = "/roomUpdate", method = RequestMethod.PUT)
    public ApiResponse updateRoom(@RequestBody Room room){
        try{
            List<Room> rooms = roomService.findRoomById(room.getId());
            return new ApiResponse(Status.OK, new RoomDTO(rooms),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"This room doesn't exist: " + room.getId()));
        }
    }

    @RequestMapping(value = "/categoryUpdate", method = RequestMethod.PUT)
    public ApiResponse updateCategory(@RequestBody RoomCategory roomCategory){
        try{
            RoomCategory category = roomCategoryService.findById(roomCategory.getId());
            return new ApiResponse(Status.OK,new RoomCategoryDTO(category),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"This category doesn't exist"));
        }
    }

    @RequestMapping(value = "/bookingUpdate", method = RequestMethod.PUT)
    public ApiResponse updateBooking(@RequestBody Booking booking){
        try {
            List<Booking> booking1 = bookingService.findByRoomId(booking.getId());
            return new ApiResponse(Status.OK,new BookingDTO(booking1),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"This booking doesn't exist"));
        }
    }

    @RequestMapping(value = "/pricingUpdate", method = RequestMethod.PUT)
    public ApiResponse updatePricing(@RequestBody Pricing pricing){
        try{
            List<Pricing> pricings = pricingService.findById(pricing.getId());
            return new ApiResponse(Status.OK,new PricingDTO(pricings),null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"This pricing doesn't exist"));
        }
    }

    @RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.DELETE)
    public ApiResponse deleteBooking(@PathVariable Long id){
         try{
             bookingService.dropBooking(id);
             return new ApiResponse(Status.OK,null,null);
         }catch (RecordNotFoundException ex){
             return new ApiResponse(Status.ERROR,null,new ApiError(666,"This Booking doesn't exist"));
         }

    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    public ApiResponse findRoomById(@PathVariable Long id){
        try {
            List<Room> rooms = roomService.findRoomById(id);
            return new ApiResponse(Status.OK, new RoomDTO(rooms));
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR, null, new ApiError(999, "No room with ID " + id));
        }
    }

    @RequestMapping(value = "/deleteRoomCategory/{id}",method = RequestMethod.DELETE)
    public ApiResponse deleteRoomCategory(@PathVariable(value = "id")Long id){
        try{
            RoomCategory category = roomCategoryService.findById(id);
            roomCategoryService.dropRoomCategory(id);
            return new ApiResponse(Status.OK,null,null);
        }catch (RecordNotFoundException ex){
            return new ApiResponse(Status.ERROR,null,new ApiError(666,"No categories at id: " + id));
        }
    }


}

