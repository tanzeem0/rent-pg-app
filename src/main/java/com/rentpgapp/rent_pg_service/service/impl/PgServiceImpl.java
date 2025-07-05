package com.rentpgapp.rent_pg_service.service.impl;

import com.rentpgapp.rent_pg_service.dto.PayingGuestDetailsDto;
import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import com.rentpgapp.rent_pg_service.model.Rooms;
import com.rentpgapp.rent_pg_service.repository.PgRepository;
import com.rentpgapp.rent_pg_service.service.PgService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
}
