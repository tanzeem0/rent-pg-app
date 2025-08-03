package com.rentpgapp.rent_pg_service.repository;

import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import com.rentpgapp.rent_pg_service.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Rooms,Long> {

    Optional<Rooms> findByPayingGuestDetailsAndRoomNumber(
            PayingGuestDetails payingGuestDetails,
            String roomNumber
    );
}
