package com.chalnakchalnak.authservice.application.mapper;

import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.domain.model.AuthDomain;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public AuthDomain toMemberDomain(SignUpRequestDto signUpRequestDto, String uuid, String hashedPassword) {
        return AuthDomain.builder()
                .memberUuid(uuid)
                .memberId(signUpRequestDto.getMemberId())
                .password(hashedPassword)
                .nickname(signUpRequestDto.getNickname())
                .phoneNumber(signUpRequestDto.getPhoneNumber())
                .build();
    }

    public SignUpDto toSignUpDto(AuthDomain authDomain) {
        return SignUpDto.builder()
                .memberUuid(authDomain.getMemberUuid())
                .memberId(authDomain.getMemberId())
                .password(authDomain.getPassword())
                .phoneNumber(authDomain.getPhoneNumber())
                .build();
    }

}
