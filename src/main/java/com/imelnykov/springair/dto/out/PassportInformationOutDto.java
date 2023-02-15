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
public class PassportInformationOutDto {
    private int id;
    private String fullName;
    private CountryOutDto country;
    private String passportNumber;
    private LocalDateTime expirationDay;
}
