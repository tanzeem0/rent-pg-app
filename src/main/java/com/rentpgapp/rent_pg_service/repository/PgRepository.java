package com.rentpgapp.rent_pg_service.repository;

import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgRepository extends JpaRepository<PayingGuestDetails,Long> {
}
