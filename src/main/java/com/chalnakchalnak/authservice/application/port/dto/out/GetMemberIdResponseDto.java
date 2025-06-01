package com.chalnakchalnak.authservice.application.port.dto.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMemberIdResponseDto {

    private String memberId;

    @Builder
    public GetMemberIdResponseDto(String memberId) {
        this.memberId = memberId;
    }
}
