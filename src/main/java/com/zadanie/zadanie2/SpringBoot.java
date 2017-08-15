package com.zadanie.zadanie2;

import com.zadanie.zadanie2.model.*;
import com.zadanie.zadanie2.service.BookingService;
import com.zadanie.zadanie2.service.InvoiceService;
import com.zadanie.zadanie2.service.RoomCategoryService;
import com.zadanie.zadanie2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBoot implements CommandLineRunner {

    @Autowired
    private RoomCategoryService roomCategoryService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private InvoiceService invoiceService;


    public static void main(String[] args){
        SpringApplication.run(SpringBoot.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {

        RoomCategory category1 = new RoomCategory("2 osobowe pokoje", "2-osobowe", 23.66);
        RoomCategory category2 = new RoomCategory("3 osobowe pokoje", "3-osobowe", 25.66);

        roomCategoryService.insertRoomCategory(category1);
        roomCategoryService.insertRoomCategory(category2);

        Room room = new Room("Pokój nr 1", "Piękny pokój z widokiem na plaże za jedyne 199/dzien", category1);
        Room room1 = new Room("Pokój nr 2", "Bez widoku na plaże za jedyne 150/dzien", category1);

        roomService.insertRoom(room);
        roomService.insertRoom(room1);

        Invoice invoice = new Invoice("123333412333");
        Booking booking = new Booking("Kraków",
                new Date(),
                new Date(System.currentTimeMillis() + 5*1000),
                "Warzybok", "marcinwarzty@interoa.pl",
                "123455675", invoice, room);
        bookingService.insertBooking(booking);
//        Booking booking1 = new Booking("Kraków", new Date(), new Date(System.currentTimeMillis() + 5*5000), "Warzybok", "marcinwarzty@interoa.pl", "12125675", invoice, room);
//        bookingService.insertBooking(booking1);
//        Booking booking2 = new Booking("Kraków", new Date(), new Date(System.currentTimeMillis() + 5*100), "W", "marcinwarzty@interoa.pl", "144444475", invoice, room);
//        bookingService.insertBooking(booking2);
    }
}
