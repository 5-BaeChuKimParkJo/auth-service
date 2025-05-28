package com.chalnakchalnak.authservice.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExistsMemberIdRequestDto {

    private String memberId;

    @Builder
    public ExistsMemberIdRequestDto(String memberId) {
        this.memberId = memberId;
    }
}
