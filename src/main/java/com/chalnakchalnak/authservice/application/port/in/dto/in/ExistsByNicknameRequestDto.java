package com.chalnakchalnak.authservice.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExistsByNicknameRequestDto {

    private String nickname;

    @Builder
    public ExistsByNicknameRequestDto(String nickname) {
        this.nickname = nickname;
    }
}
