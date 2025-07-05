package com.rentpgapp.rent_pg_service.dto;

import com.rentpgapp.rent_pg_service.common.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private String roomNumber;
    private RoomType roomType;
    private Double rent;
    private Boolean isAvailable;
    private String amenities;
}
