package com.rentpgapp.rent_pg_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PayingGuestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pg_id")
    private Long pgId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Users owner;  // User with userType == OWNER

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "payingGuestDetails", cascade = CascadeType.ALL)
    private List<Rooms> rooms = new ArrayList<>();
}
