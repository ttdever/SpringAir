package com.imelnykov.springair.entities;

import jakarta.persistence.*;

@Entity
public class RegisteredFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
}
