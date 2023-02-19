package com.imelnykov.springair.controller;

import com.imelnykov.springair.dto.in.UserInDto;
import com.imelnykov.springair.dto.out.UserOutDto;
import com.imelnykov.springair.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${api.prefix}/user")
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserOutDto> getUserById(@PathVariable int clientId) {
        return userService.getUserById(clientId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserOutDto> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserOutDto> addUser(@RequestBody UserInDto userInDto) {
        return ResponseEntity.ok(userService.createUser(userInDto));
    }
}
