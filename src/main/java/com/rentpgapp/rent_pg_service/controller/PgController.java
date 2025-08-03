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
import java.util.Map;

@RestController
@RequestMapping(path = "/api/pgs")
@RequiredArgsConstructor
public class PgController {
    // contains https methods for Users
    private final PgService pgService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<PayingGuestDetailsDto>> getAllPgsUsers(@RequestParam String city,
                                                      @RequestParam String location,
                                                      @RequestParam(required = false) String address){

        return ResponseEntity.ok(pgService.getAllPgs(city,location,address));
    }

    @GetMapping("/users/{name}/{location}")
    public ResponseEntity<PayingGuestDetailsDto> getPgByNameAndLocation(@PathVariable String name,
                                                                        @PathVariable String location) {
        PayingGuestDetailsDto pg = pgService.getPgByNameAndLocation(name, location);
        return ResponseEntity.ok(pg);
    }

    @DeleteMapping("/owners/{ownerId}")
    public ResponseEntity<String> deletePgByNameAndLocation(@PathVariable Long ownerId,
                                                            @RequestParam(value = "name") String name,
                                                            @RequestParam(value = "location") String location)
    {
        pgService.deletePgByNameAndLocation(ownerId, name, location);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{ownerId}")
    public ResponseEntity<PayingGuestDetailsDto> addPg(@PathVariable Long ownerId,
                                                       @RequestBody PayingGuestDetailsPostDto pgDto) {
        PayingGuestDetailsDto created = pgService.addPg(ownerId, pgDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/owner/{ownerId}/{pgId}/room")
    public ResponseEntity<PayingGuestDetailsDto> addRoomToPg(@PathVariable Long ownerId,
                                                             @PathVariable Long pgId,
                                                             @RequestBody RoomDto roomDto) {
        PayingGuestDetailsDto updatedPg = pgService.addRoomToPg(ownerId, pgId, roomDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedPg);
    }
}
