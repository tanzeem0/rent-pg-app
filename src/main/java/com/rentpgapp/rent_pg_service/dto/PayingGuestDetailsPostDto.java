package com.rentpgapp.rent_pg_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayingGuestDetailsPostDto {
    private String name;
    private String location;
    private String city;
    private String address;
    private String description;
    private List<RoomDto> rooms;
}
