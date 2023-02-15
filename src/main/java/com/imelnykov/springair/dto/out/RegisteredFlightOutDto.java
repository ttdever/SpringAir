package com.imelnykov.springair.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredFlightOutDto {
    private int id;
    private UserOutDto user;
    private DestinationOutDto destination;
}
