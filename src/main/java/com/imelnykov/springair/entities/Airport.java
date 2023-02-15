package com.imelnykov.springair.entities;

import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private String codeName;
}
