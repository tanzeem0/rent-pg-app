package com.rentpgapp.rent_pg_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentpgapp.rent_pg_service.common.RoomType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pg_id", nullable = false)
    @JsonIgnore
    private PayingGuestDetails payingGuestDetails;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @Column(name = "rent", nullable = false)
    private Double rent;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "amenities")
    private String amenities;
}
