package com.imelnykov.springair.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationOutDto {
    private int id;
    private AirportOutDto from;
    private AirportOutDto to;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
