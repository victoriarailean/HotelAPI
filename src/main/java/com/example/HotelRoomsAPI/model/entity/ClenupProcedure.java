package com.example.HotelRoomsAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClenupProcedure {

    public ClenupProcedure(String name, int outcome, Room room){
        this.name = name;
        this.outcome= outcome;
        this.room = room;

    }

    @Id
    @GeneratedValue

    private Long id;
    private  String name;
    private  int outcome;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}
