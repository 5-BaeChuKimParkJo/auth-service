package com.chalnakchalnak.authservice.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExistsByMemberIdRequestDto {

    private String memberId;

    @Builder
    public ExistsByMemberIdRequestDto(String memberId) {
        this.memberId = memberId;
    }
}
