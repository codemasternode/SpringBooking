package com.zadanie.zadanie2.dto;

import com.zadanie.zadanie2.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;

public class RoomDTO {
    private Long id;
    private String name;
    private String descrtiption;
    private Long roomCategoriesId;
    private List<Room> rooms = new ArrayList<>();

    public RoomDTO() {
    }


    public RoomDTO(List<Room> rooms){
        this.rooms = rooms;
    }

    public RoomDTO(Room room){
        this.name = room.getName();
        this.descrtiption = room.getDescription();
        this.roomCategoriesId = room.getRoomCategory().getId();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescrtiption() {
        return descrtiption;
    }

    public Long getRoomCategoryId() {
        return roomCategoriesId;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
