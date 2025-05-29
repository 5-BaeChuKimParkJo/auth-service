package com.chalnakchalnak.authservice.application.port.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReissueAllTokenRequestDto {

    private String refreshToken;

    @Builder
    public ReissueAllTokenRequestDto(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
