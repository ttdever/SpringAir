package com.imelnykov.springair.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne
    @JoinColumn(name = "passport_id")
    private PassportInformation passportInformation;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToOne
    @JoinColumn(name = "contact_id")
    private ContactInformation contactId;
    @OneToMany(mappedBy = "user")
    private List<RegisteredFlight> registeredFlights;
}
