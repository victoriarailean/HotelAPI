package com.example.HotelRoomsAPI.repositories;

import com.example.HotelRoomsAPI.model.entity.Reviews;
import com.example.HotelRoomsAPI.model.entity.Room;
import com.example.HotelRoomsAPI.model.entity.RoomFacilities;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomFacilitiesRepository extends CrudRepository<RoomFacilities, Long> {
    List<RoomFacilities> findByRoom(Room room);

    void deleteByRoom(Room room);
}
