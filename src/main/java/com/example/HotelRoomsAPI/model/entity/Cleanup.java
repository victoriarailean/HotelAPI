package com.example.HotelRoomsAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cleanup {
    public Cleanup( Date date, String proceduri, Room room){
        this.date = date;
        this.proceduri = proceduri;
        this.room = room;
    }
    @Id
    @GeneratedValue

    private Long id;
    private Date date;
    private String proceduri;



    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}
