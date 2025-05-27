package com.chalnakchalnak.authservice.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExistsByPhoneNumberRequestDto {

    private String phoneNumber;

    @Builder
    public ExistsByPhoneNumberRequestDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
