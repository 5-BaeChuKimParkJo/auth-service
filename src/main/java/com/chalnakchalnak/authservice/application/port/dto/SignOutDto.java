package com.chalnakchalnak.authservice.application.port.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignOutDto {

    private String refreshToken;

    @Builder
    public SignOutDto(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
