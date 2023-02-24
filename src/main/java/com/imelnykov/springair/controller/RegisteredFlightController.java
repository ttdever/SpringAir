package com.imelnykov.springair.controller;

import com.imelnykov.springair.dto.out.RegisteredFlightOutDto;
import com.imelnykov.springair.service.RegisteredFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${api.prefix}/registered-flights")
public class RegisteredFlightController {

    @Autowired
    private RegisteredFlightService flightService;

    @GetMapping(path = "/by-user-id/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegisteredFlightOutDto>> getRegisteredFlightByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(flightService.getRegisteredFlightsByUserId(userId));
    }

    @GetMapping(path = "/by-principal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegisteredFlightOutDto>> getRegisteredFlightByPrincipal(Principal principal) {
        return ResponseEntity.ok(flightService.getRegisteredFlightsByEmail(principal.getName()));
    }

    @GetMapping(path = "/by-flight-id/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredFlightOutDto> getRegisteredFlightByFlightId(@PathVariable int flightId) {
        return flightService.getRegisteredFlightByFlightId(flightId).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/assign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredFlightOutDto>
        assignFlightToUser(@RequestParam int userId, @RequestParam int destinationId) {
        System.out.println("Got assign request from user id = " + userId);
        return ResponseEntity.ok(flightService.registerNewFlight(userId, destinationId));
    }

    @DeleteMapping(path = "/cancel/{flightId}")
    public ResponseEntity<Void> cancelFlight(@PathVariable int flightId) {
        flightService.cancelRegisteredFlight(flightId);
        return ResponseEntity.noContent().build();
    }
}