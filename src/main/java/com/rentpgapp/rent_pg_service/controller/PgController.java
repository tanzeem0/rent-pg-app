package com.rentpgapp.rent_pg_service.controller;

import com.rentpgapp.rent_pg_service.dto.PayingGuestDetailsDto;
import com.rentpgapp.rent_pg_service.service.PgService;
import com.rentpgapp.rent_pg_service.service.impl.PgServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pgs")
@RequiredArgsConstructor
public class PgController {
    // contains https methods for Users
    private final PgService pgService;

    @GetMapping(path = "/users")
    public List<PayingGuestDetailsDto> getAllPgsUsers(@RequestParam String city,
                                                      @RequestParam String location,
                                                      @RequestParam(required = false) String address){

        return pgService.getAllPgs(city,location,address);
    }
}
