package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity.AuthEntity;
import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import org.springframework.stereotype.Component;

@Component
public class AuthEntityMapper {

    public AuthEntity toEntity(SignUpDto signUpDto) {
        return AuthEntity.builder()
                .memberUuid(signUpDto.getMemberUuid())
                .memberId(signUpDto.getMemberId())
                .password(signUpDto.getPassword())
                .phoneNumber(signUpDto.getPhoneNumber())
                .build();
    }
}
