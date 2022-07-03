package com.example.HotelRoomsAPI;

import com.example.HotelRoomsAPI.model.entity.Room;
import com.example.HotelRoomsAPI.repositories.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RoomService {

    RoomRepository roomRepository;
    CleanupProcedureRepository cleanupProcedureRepository;
    CleanupRepository cleanupRepository;
    ReviewRepository reviewRepository;
    RoomFacilitiesRepository roomFacilitiesRepository;

    public RoomService(RoomRepository roomRepository,
                       CleanupProcedureRepository cleanupProcedureRepository,
                       CleanupRepository cleanupRepository,
                       ReviewRepository reviewRepository,
                       RoomFacilitiesRepository roomFacilitiesRepository)
    {
        this.roomRepository = roomRepository;
        this.cleanupProcedureRepository = cleanupProcedureRepository;
        this.cleanupRepository = cleanupRepository;
        this.reviewRepository = reviewRepository;
        this.roomFacilitiesRepository = roomFacilitiesRepository;
    }

    public  void deleteRoom(Room room) {
        cleanupProcedureRepository.deleteByRoom(room);
        cleanupRepository.deleteByRoom(room);
        reviewRepository.deleteByRoom(room);
        roomFacilitiesRepository.deleteByRoom(room);
        roomRepository.delete(room);
    }


}
