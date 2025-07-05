package com.rentpgapp.rent_pg_service.dto;

import com.rentpgapp.rent_pg_service.model.Rooms;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {
    private String name;
    private String email;
}

