package com.rentpgapp.rent_pg_service.model;

import com.rentpgapp.rent_pg_service.common.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name ="phone_number",nullable = false)
    private Long phoneNumber;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Roles roles;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
