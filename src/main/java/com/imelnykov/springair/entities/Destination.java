package com.imelnykov.springair.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "from_id")
    private Airport from;
    @OneToOne
    @JoinColumn(name = "to_id")
    private Airport to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
