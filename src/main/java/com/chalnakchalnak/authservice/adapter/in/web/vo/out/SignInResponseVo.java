package com.chalnakchalnak.authservice.adapter.in.web.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInResponseVo {

    private String accessToken;
    private String refreshToken;

    @Builder
    public SignInResponseVo(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
