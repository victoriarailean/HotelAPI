package com.example.HotelRoomsAPI.repositories;

import com.example.HotelRoomsAPI.model.entity.Reviews;
import com.example.HotelRoomsAPI.model.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Reviews, Long> {
    List<Reviews> findByRoom(Room room);

    void deleteByRoom(Room room);
}
