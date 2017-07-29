package com.zadanie.zadanie2;

import com.zadanie.zadanie2.model.Pricing;
import com.zadanie.zadanie2.model.Room;
import com.zadanie.zadanie2.model.RoomCategory;
import com.zadanie.zadanie2.service.RoomCategoryService;
import com.zadanie.zadanie2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBoot implements CommandLineRunner {

    @Autowired
    private RoomCategoryService roomCategoryService;

    @Autowired
    private RoomService roomService;

    public static void main(String[] args){
        SpringApplication.run(SpringBoot.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Room room = new Room("Pokój nr 1","Piękny pokój z widokiem na plaże za jedyne 199/dzien");
        Room room1 = new Room("Pokój nr 2","Bez widoku na plaże za jedyne 150/dzien");
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room1);
        Pricing pricing = new Pricing();
        RoomCategory category = new RoomCategory("2 osobowe pokoje","2-osobowe",rooms,pricing);
        roomCategoryService.insertRoomCategory(category);


    }
}
