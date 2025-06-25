package com.rentpgapp.rent_pg_service.model;

import com.rentpgapp.rent_pg_service.common.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

//    Will uncomment later
//    @ManyToOne
//    @JoinColumn(name = "pg_id", nullable = false)
//    private PayingGuestDetails payingGuestDetails;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @Column(name = "rent", nullable = false)
    private Double rent;

    @Column(name = "is_available")
    private Boolean isAvailable;
}
