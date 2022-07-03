package com.example.HotelRoomsAPI.repositories;

import com.example.HotelRoomsAPI.model.entity.ClenupProcedure;
import com.example.HotelRoomsAPI.model.entity.Reviews;
import com.example.HotelRoomsAPI.model.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CleanupProcedureRepository extends CrudRepository<ClenupProcedure, Long> {
        List<ClenupProcedure> findByRoom(Room room);

        void deleteByRoom(Room room);
}

