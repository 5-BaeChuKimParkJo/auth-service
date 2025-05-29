package com.chalnakchalnak.authservice.application.port.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInDto {

    private String memberUuid;
    private String memberId;
    private String password;

    @Builder
    public SignInDto(String memberUuid, String memberId, String password) {
        this.memberUuid = memberUuid;
        this.memberId = memberId;
        this.password = password;
    }

}
