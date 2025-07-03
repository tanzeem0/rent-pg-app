package com.rentpgapp.rent_pg_service.dto;

import com.rentpgapp.rent_pg_service.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayingGuestDetailsDto {
    private Long pgId;
    private String name;
    private String location;
    private String city;
    private String address;
    private String description;
    private OwnerDto owner;
}
