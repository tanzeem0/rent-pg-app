package com.rentpgapp.rent_pg_service.service;

import com.rentpgapp.rent_pg_service.dto.PayingGuestDetailsDto;
import com.rentpgapp.rent_pg_service.dto.RoomDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PgService {

    List<PayingGuestDetailsDto> getAllPgs(String city,String location,String address);

    PayingGuestDetailsDto getPgByNameAndLocation(String name, String location);

    PayingGuestDetailsDto addPg(Long ownerId, PayingGuestDetailsDto pgDto);

    PayingGuestDetailsDto addRoomToPg(Long ownerId, Long pgId, RoomDto roomDto);

    boolean deletePgByNameAndLocation(String name, String location);
}
