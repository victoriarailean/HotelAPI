package com.example.HotelRoomsAPI.controller;

import com.example.HotelRoomsAPI.RoomService;
import com.example.HotelRoomsAPI.model.entity.Cleanup;
import com.example.HotelRoomsAPI.model.entity.Room;
import com.example.HotelRoomsAPI.repositories.CleanupRepository;
import com.example.HotelRoomsAPI.repositories.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    RoomRepository roomRepository;
    RoomService roomService;
    CleanupRepository cleanupRepository;

    public RoomController(RoomRepository roomRepository, RoomService roomService, CleanupRepository cleanupRepository) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
        this.cleanupRepository = cleanupRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
       return roomRepository.findAll();
    }

    @GetMapping("{id}")
    public Room roomId(@PathVariable Long id) throws Exception {
        return roomRepository.findAllById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(roomRepository.findAllById(id));
    }


    @GetMapping("/filter")
    public List<Room> dataFilter(@RequestParam(required = false) String number ) {
        List<Room> rooms = roomRepository.findAll();
        List<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (number != null) {
                if (number.equals(room.getNumber())) {
                    filteredRooms.add(room);
                }
            }
        }
        return filteredRooms;
    }

    @GetMapping("{id}/cleanup")
    public Cleanup cleanup(@PathVariable Long id)  {
        return cleanupRepository.findByRoomId(id);
    }
}
