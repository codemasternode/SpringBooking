package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.model.Room;
import com.zadanie.zadanie2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Room insertRoom(Room room){
        return roomRepository.save(room);
    }

}
