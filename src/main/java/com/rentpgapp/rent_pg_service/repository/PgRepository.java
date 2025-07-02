package com.rentpgapp.rent_pg_service.repository;

import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PgRepository extends JpaRepository<PayingGuestDetails,Long> {

    List<PayingGuestDetails> findByCityAndLocation(String city,String location);
}
