package com.example.HotelRoomsAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reviews {
    @Id
    @GeneratedValue
    private Long id;
    private String mesaj;

    public Reviews(String mesaj, int rating, String turist, Room room) {
        this.mesaj = mesaj;
        this.rating = rating;
        this.turist = turist;
        this.room = room;
    }

    private int rating;
    private String turist;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

}
