package com.chalnakchalnak.authservice.application.port.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMemberIdDto {

    private String phoneNumber;

    @Builder
    public GetMemberIdDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
