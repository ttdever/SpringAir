package com.imelnykov.springair.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformationInDto {
    private String phoneNumber;
    private String email;
    private String address;
}
