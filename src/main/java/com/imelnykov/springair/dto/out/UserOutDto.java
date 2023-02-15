package com.imelnykov.springair.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOutDto {
    private int id;
    private RoleOutDto role;
    private PassportInformationOutDto passportInformation;
    private ContactInformationOutDto contactInformation;
}
