package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity.AuthEntity;
import com.chalnakchalnak.authservice.application.port.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.dto.out.AuthResponseDto;
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

    public AuthResponseDto toAuthResponseDto(AuthEntity authEntity) {
        return AuthResponseDto.builder()
                .memberUuid(authEntity.getMemberUuid())
                .memberId(authEntity.getMemberId())
                .password(authEntity.getPassword())
                .phoneNumber(authEntity.getPhoneNumber())
                .createdAt(authEntity.getCreatedAt())
                .updatedAt(authEntity.getUpdatedAt())
                .build();
    }
}
