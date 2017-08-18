package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.exceptions.RecordNotFoundException;
import com.zadanie.zadanie2.helpers.ApiResponse;
import com.zadanie.zadanie2.helpers.ApiResponse.Status;
import com.zadanie.zadanie2.helpers.ApiResponse.ApiError;
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
        List<Room> rooms = roomRepository.findAll();
        if(rooms.isEmpty()){
            throw new RecordNotFoundException("No any rooms");
        }
        return rooms;
    }

    public Room insertRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> findRoomById(Long id){
        List<Room> rooms = roomRepository.findRoomById(id);
        if(rooms == null){
            throw new RecordNotFoundException("No room with ID " + id);
        }
        return rooms;
    }

    public void dropRoom(Long id){
        List<Room> rooms = roomRepository.findRoomById(id);
       if(rooms.isEmpty()){
           throw new RecordNotFoundException("I can't find record to remove");
       }
       roomRepository.delete(id);
    }
    public Room updateData(Room room){
        return roomRepository.save(room);
    }

}
