package com.imelnykov.springair.service;

import com.imelnykov.springair.dao.DestinationDao;
import com.imelnykov.springair.dao.RegisteredFlightDao;
import com.imelnykov.springair.dao.UserDao;
import com.imelnykov.springair.dto.out.RegisteredFlightOutDto;
import com.imelnykov.springair.entities.Destination;
import com.imelnykov.springair.entities.RegisteredFlight;
import com.imelnykov.springair.entities.User;
import com.imelnykov.springair.global.exceptions.alreadyassigned.DestinationAlreadyAssignedException;
import com.imelnykov.springair.global.exceptions.notfound.DestinationNotFoundException;
import com.imelnykov.springair.global.exceptions.notfound.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisteredFlightService {
    @Autowired
    private RegisteredFlightDao registeredFlightDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DestinationDao destinationDao;


    @Autowired
    private ModelMapper mapper;

    public List<RegisteredFlightOutDto> getRegisteredFlightsByUserId(int userId) {
        return registeredFlightDao.findRegisteredFlightsByUserId(userId)
                .stream().map(this::mapFlightToFlightOutDto).collect(Collectors.toList());
    }

    public List<RegisteredFlightOutDto> getRegisteredFlightsByEmail(String email) {
        return registeredFlightDao.findRegisteredFlightsByEmail(email)
                .stream().map(this::mapFlightToFlightOutDto).collect(Collectors.toList());
    }

    public Optional<RegisteredFlightOutDto> getRegisteredFlightByFlightId(int flightId) {
        return registeredFlightDao.findById(flightId).map(this::mapFlightToFlightOutDto);
    }

    @Transactional
    public RegisteredFlightOutDto registerNewFlight(int userId, int destinationId) {
        System.out.println("Got in registration method");
        User user = userDao.findById(userId).
                orElseThrow(() -> new UserNotFoundException(userId));
        System.out.println("Got USER");
        Destination destination = destinationDao.findById(destinationId)
                .orElseThrow(() -> new DestinationNotFoundException(destinationId));
        System.out.println("Got DESTINATION");

        List<Destination> userDestinations = registeredFlightDao.findRegisteredFlightsByUserId(userId)
                .stream().map(RegisteredFlight::getDestination).toList();
        System.out.println("Got USER DESTINATIONS");
        if(userDestinations.contains(destination)) {
            throw new DestinationAlreadyAssignedException(userId, destinationId);
        }
        System.out.println("CHECKED FOR CONTAINS");

        RegisteredFlight registeredFlight = new RegisteredFlight();
        registeredFlight.setUser(user);
        registeredFlight.setDestination(destination);
        System.out.println("CREATED FLIGHT");
        return mapFlightToFlightOutDto(registeredFlightDao.save(registeredFlight));
    }

    private RegisteredFlightOutDto mapFlightToFlightOutDto(RegisteredFlight registeredFlight) {
        return mapper.map(registeredFlight, RegisteredFlightOutDto.class);
    }
}
