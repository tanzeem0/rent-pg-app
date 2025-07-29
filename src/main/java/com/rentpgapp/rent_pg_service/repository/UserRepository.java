package com.rentpgapp.rent_pg_service.repository;

import com.rentpgapp.rent_pg_service.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

}
