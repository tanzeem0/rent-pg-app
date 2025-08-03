package com.rentpgapp.rent_pg_service.repository;

import com.rentpgapp.rent_pg_service.model.PayingGuestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PgRepository extends JpaRepository<PayingGuestDetails,Long> {

    List<PayingGuestDetails> findByCityAndLocation(String city,String location);

    Optional<PayingGuestDetails> findByNameAndLocation(String name, String location);

    @Query("SELECT pg FROM PayingGuestDetails pg WHERE pg.owner.id = :ownerId AND pg.name = :name AND pg.location = :location")
    Optional<PayingGuestDetails> findPgByNameLocationAndOwner(@Param("name") String name,
                                                                @Param("location") String location,
                                                                @Param("ownerId") Long ownerId);
}
