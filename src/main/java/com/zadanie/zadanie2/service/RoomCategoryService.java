package com.zadanie.zadanie2.service;

import com.zadanie.zadanie2.exceptions.RecordNotFoundException;
import com.zadanie.zadanie2.model.Room;
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
        List<RoomCategory> categories = roomCategoryRepository.findAll();
        if(categories.isEmpty()){
            throw new RecordNotFoundException("There aren't any categories");
        }
        return categories;
    }

    public void dropRoomCategory(Long id){
        roomCategoryRepository.delete(id);
    }

    public RoomCategory findById(Long id){
        RoomCategory category = roomCategoryRepository.findById(id);
        if(category == null){
            throw new RecordNotFoundException("I can't find the record to remove");
        }
        return null;
    }

}
