package com.imelnykov.springair.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationInDto {
    private AirportInDto from;
    private AirportInDto to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
