package com.rentpgapp.rent_pg_service.controller;

import com.rentpgapp.rent_pg_service.dto.PayingGuestDetailsDto;
import com.rentpgapp.rent_pg_service.dto.PayingGuestDetailsPostDto;
import com.rentpgapp.rent_pg_service.dto.RoomDto;
import com.rentpgapp.rent_pg_service.service.PgService;
import com.rentpgapp.rent_pg_service.service.impl.PgServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{name}/{location}")
    public PayingGuestDetailsDto getPgByNameAndLocation(@PathVariable String name,
                                                   @PathVariable String location) {
        return ResponseEntity.ok(pgService.getPgByNameAndLocation(name, location)).getBody();
    }

    @DeleteMapping("/owners/{name}/{location}")
    public boolean deletePgByNameAndLocation(@PathVariable String name, @PathVariable String location)
    {
        return pgService.deletePgByNameAndLocation(name,location);
    }

    @PostMapping("/{ownerId}")
    public PayingGuestDetailsDto addPg(@PathVariable Long ownerId,
                                       @RequestBody PayingGuestDetailsPostDto pgDto) {
        PayingGuestDetailsDto created = pgService.addPg(ownerId, pgDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED).getBody();
    }

    @PostMapping("/owner/{ownerId}/{pgId}/room")
    public PayingGuestDetailsDto addRoomToPg(@PathVariable Long ownerId,
                                             @PathVariable Long pgId,
                                             @RequestBody RoomDto roomDto) {
        PayingGuestDetailsDto updated = pgService.addRoomToPg(ownerId, pgId, roomDto);
        return new ResponseEntity<>(updated, HttpStatus.CREATED).getBody();
    }
}
