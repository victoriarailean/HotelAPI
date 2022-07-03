package com.example.HotelRoomsAPI.repositories;

import com.example.HotelRoomsAPI.model.entity.Cleanup;
import com.example.HotelRoomsAPI.model.entity.Reviews;
import com.example.HotelRoomsAPI.model.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CleanupRepository   extends CrudRepository<Cleanup, Long> {
    List<Cleanup> findByRoom(Room room);

    void deleteByRoom(Room room);
    Cleanup findByRoomId(Long id);
}
