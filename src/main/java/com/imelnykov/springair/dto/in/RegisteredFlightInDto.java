package com.imelnykov.springair.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredFlightInDto {
    private UserInDto user;
    private DestinationInDto destination;
}
