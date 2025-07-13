package com.rentpgapp.rent_pg_service.repository;

import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PgRepository extends JpaRepository<PayingGuestDetails,Long> {

    List<PayingGuestDetails> findByCityAndLocation(String city,String location);

    Optional<PayingGuestDetails> findByNameAndLocation(String name, String location);

    boolean deletePgByNameAndLocation(String name, String location);
}
