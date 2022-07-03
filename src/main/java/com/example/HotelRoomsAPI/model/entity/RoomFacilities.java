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
public class RoomFacilities {

    public RoomFacilities(boolean TV, boolean doubleBed){
        this.TV = TV;
        this.doubleBed = doubleBed;
    }

    @Id
    @GeneratedValue
    private Long id;
    private boolean TV;
    private boolean doubleBed;

    @OneToOne
    private Room room;

}
