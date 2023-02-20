package com.imelnykov.springair.dao;

import com.imelnykov.springair.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationDao extends JpaRepository<Destination, Integer> {
}
