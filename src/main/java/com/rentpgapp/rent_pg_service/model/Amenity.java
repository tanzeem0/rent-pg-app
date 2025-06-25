package com.rentpgapp.rent_pg_service.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "amenities")
    private List<PayingGuestDetails> pgList;
}

