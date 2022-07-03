package com.example.HotelRoomsAPI.repositories;

import com.example.HotelRoomsAPI.model.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();
    List<Room> findAllByNumber(String number);

    Room findAllById(Long roomId);
}
