package com.example.HotelRoomsAPI;

import com.example.HotelRoomsAPI.model.entity.*;
import com.example.HotelRoomsAPI.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataLoader implements ApplicationRunner {
    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;
    private final CleanupRepository cleanupRepository;
    private final RoomFacilitiesRepository roomFacilitiesRepository;
    private final CleanupProcedureRepository cleanupProcedureRepository;

    @Autowired
    public  DataLoader(RoomRepository roomRepository, ReviewRepository reviewRepository, CleanupRepository cleanupRepository, RoomFacilitiesRepository roomFacilitiesRepository, CleanupProcedureRepository cleanupProcedureRepository){
        this.roomRepository = roomRepository;
        this.reviewRepository = reviewRepository;
        this.cleanupRepository =  cleanupRepository;
        this.roomFacilitiesRepository = roomFacilitiesRepository;
        this.cleanupProcedureRepository = cleanupProcedureRepository;
    }

    public void run(ApplicationArguments args) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        RoomFacilities roomFacilities = new RoomFacilities(true, true);
        RoomFacilities roomFacilities1 = new RoomFacilities(true, true);
        Room room = new Room("12", 2, "Hotel", roomFacilities);
        Room room1 = new Room("13", 2, "Hotel_Grand", roomFacilities);
        Room room2 = new Room("14", 2, "Hotel_Grand", roomFacilities);

        Reviews review1 = new Reviews("mesaj", 2, "turist1", room);
        Cleanup cleanup = new Cleanup(f.parse("2022-06-30"), "proc", room);
        ClenupProcedure clenupProcedure = new ClenupProcedure("Procedure1", 21, room);

        roomFacilitiesRepository.save(roomFacilities);
        roomFacilitiesRepository.save(roomFacilities1);

        roomRepository.save(room);
        roomRepository.save(room1);
        roomRepository.save(room2);

        reviewRepository.save(review1);

        cleanupRepository.save(cleanup);

        cleanupProcedureRepository.save(clenupProcedure);

    }
}
