package com.imelnykov.springair.dao;

import com.imelnykov.springair.entities.RegisteredFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisteredFlightDao extends JpaRepository<RegisteredFlight, Integer> {

    List<RegisteredFlight> findRegisteredFlightsByUserId(int userId);

    @Query("""
        SELECT f FROM RegisteredFlight f
        JOIN f.user u
        WHERE u.contact.email = :email
        """)
    List<RegisteredFlight> findRegisteredFlightsByEmail(String email);
}
