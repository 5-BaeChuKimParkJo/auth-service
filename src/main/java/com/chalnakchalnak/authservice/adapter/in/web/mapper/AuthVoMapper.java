package com.chalnakchalnak.authservice.adapter.in.web.mapper;

import com.chalnakchalnak.authservice.adapter.in.web.vo.in.SignUpRequestVo;
import com.chalnakchalnak.authservice.application.port.in.dto.SignUpRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AuthVoMapper {

    public SignUpRequestDto toSignUpRequestDto(SignUpRequestVo signUpRequestVo) {
        return SignUpRequestDto.builder()
                .memberId(signUpRequestVo.getMemberId())
                .password(signUpRequestVo.getPassword())
                .nickname(signUpRequestVo.getNickname())
                .phoneNumber(signUpRequestVo.getPhoneNumber())
                .build();
    }
}
