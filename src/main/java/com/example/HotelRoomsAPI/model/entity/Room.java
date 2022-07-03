package com.example.HotelRoomsAPI.model.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Room {

    public Room(String number, int etaj, String hotel_name, RoomFacilities roomFacilities) {
        this.number = number;
        this.etaj = etaj;
        this.hotelName = hotel_name;
        this.roomFacilities = roomFacilities;
    }

    @Id
    @GeneratedValue
    @Column (name = "id")
    private Long id;

    @Column (name = "number")
    private String number;

    @Column (name = "etaj")
    private int etaj;

    @Column(name = "hotel_name")
    private String hotelName;


    @OneToOne
    @JoinColumn(name="room_facilities_id")
    private RoomFacilities roomFacilities;

}
