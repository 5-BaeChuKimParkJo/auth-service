package com.chalnakchalnak.authservice.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExistsNicknameRequestDto {

    private String nickname;

    @Builder
    public ExistsNicknameRequestDto(String nickname) {
        this.nickname = nickname;
    }
}
