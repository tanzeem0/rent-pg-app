package com.rentpgapp.rent_pg_service.service.impl;

import com.rentpgapp.rent_pg_service.dto.PayingGuestDetailsDto;
import com.rentpgapp.rent_pg_service.dto.RoomDto;
import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import com.rentpgapp.rent_pg_service.model.Rooms;
import com.rentpgapp.rent_pg_service.model.Users;
import com.rentpgapp.rent_pg_service.repository.PgRepository;
import com.rentpgapp.rent_pg_service.service.PgService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PgServiceImpl implements PgService {

    private final PgRepository pgRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PayingGuestDetailsDto> getAllPgs(String city,String location,String address) {
        List<PayingGuestDetails> payingGuestDetailsEntityList = pgRepository.findByCityAndLocation(city,location);
        payingGuestDetailsEntityList = payingGuestDetailsEntityList.stream()
                .filter(pg -> pg.getRooms().stream().anyMatch(Rooms::getIsAvailable))
                .toList();
        List<PayingGuestDetailsDto> payingGuestDetailsDtos = payingGuestDetailsEntityList
                .stream()
                .map(everyPgDetail->modelMapper.map(everyPgDetail, PayingGuestDetailsDto.class))
                .toList();
        return payingGuestDetailsDtos;
    }

    @Override
    public PayingGuestDetailsDto getPgByNameAndLocation(String name, String location) {
        PayingGuestDetails pg = pgRepository.findByNameAndLocation(name, location)
                .orElseThrow(() -> new EntityNotFoundException("PG not found"));
        boolean hasAvailableRoom = pg.getRooms().stream().anyMatch(Rooms::getIsAvailable);
        if (!hasAvailableRoom) {
            throw new RuntimeException("No available rooms in this PG");
        }
        return modelMapper.map(pg, PayingGuestDetailsDto.class);
    }

//    @Override
//    public void deletePgByNameAndLocation(String name, String location) {
//        PayingGuestDetails pg = pgRepository.findByNameAndLocation(name, location)
//                .orElseThrow(() -> new EntityNotFoundException("PG not found"));
//        pgRepository.delete(pg);
//    }

    @Override
    public boolean deletePgByNameAndLocation(String name, String location) {
        try {
            PayingGuestDetails pg = pgRepository.findByNameAndLocation(name, location)
                    .orElseThrow(() -> new EntityNotFoundException("PG not found"));
            pgRepository.delete(pg);
            return true; // successfully deleted
        } catch (Exception e) {
            return false; // deletion failed
        }
    }

    @Override
    public PayingGuestDetailsDto addPg(Long ownerId, PayingGuestDetailsDto pgDto) {
        Users owner = pgRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found")).getOwner();
        PayingGuestDetails pgEntity = modelMapper.map(pgDto, PayingGuestDetails.class);
        pgEntity.setOwner(owner);
        pgEntity.setCreatedAt(LocalDateTime.now());
        if (pgEntity.getRooms() != null) {
            for (Rooms room : pgEntity.getRooms()) {
                room.setPayingGuestDetails(pgEntity);
            }
        }
        PayingGuestDetails saved = pgRepository.save(pgEntity);
        return modelMapper.map(saved, PayingGuestDetailsDto.class);
    }

    @Override
    public PayingGuestDetailsDto addRoomToPg(Long ownerId, Long pgId, RoomDto roomDto) {
        PayingGuestDetails pg = pgRepository.findById(pgId)
                .orElseThrow(() -> new EntityNotFoundException("PG not found"));

        if (!pg.getOwner().getUser_id().equals(ownerId)) {
            throw new RuntimeException("You are not authorized to add rooms to this PG");
        }

        Rooms room = modelMapper.map(roomDto, Rooms.class);
        room.setPayingGuestDetails(pg);
        pg.getRooms().add(room);

        PayingGuestDetails updatedPg = pgRepository.save(pg);
        return modelMapper.map(updatedPg, PayingGuestDetailsDto.class);
    }
}
