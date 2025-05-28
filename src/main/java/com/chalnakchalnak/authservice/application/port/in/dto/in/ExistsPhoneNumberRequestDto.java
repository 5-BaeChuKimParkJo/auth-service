package com.chalnakchalnak.authservice.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExistsPhoneNumberRequestDto {

    private String phoneNumber;

    @Builder
    public ExistsPhoneNumberRequestDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
