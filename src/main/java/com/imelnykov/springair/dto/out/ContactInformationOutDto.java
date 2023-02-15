package com.imelnykov.springair.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformationOutDto {
    private int id;
    private String phoneNumber;
    private String email;
    private String address;
}
