package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.model.RoomCategory;
import com.zadanie.zadanie2.repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomCategoryService {
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    public RoomCategory insertRoomCategory(RoomCategory roomCategory){
        return roomCategoryRepository.save(roomCategory);
    }

    public List<RoomCategory> findAll(){
        return roomCategoryRepository.findAll();
    }

    public void dropRoomCategory(Long id){
        roomCategoryRepository.delete(id);
    }


}
