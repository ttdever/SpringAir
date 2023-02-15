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
public class PassportInformationInDto {
    private String fullName;
    private CountryInDto country;
    private String passportNumber;
    private LocalDateTime expirationDay;
}
