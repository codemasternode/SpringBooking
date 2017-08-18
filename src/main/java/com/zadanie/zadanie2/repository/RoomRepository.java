package com.zadanie.zadanie2.repository;

import com.zadanie.zadanie2.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>{
    public List<Room> findRoomById(Long id);

}
