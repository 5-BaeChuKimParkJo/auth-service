package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.mapper;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity.MemberEntity;
import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import org.springframework.stereotype.Component;

@Component
public class AuthEntityMapper {

    public MemberEntity toEntity(SignUpDto signUpDto) {
        return MemberEntity.builder()
                .memberUuid(signUpDto.getMemberUuid())
                .memberId(signUpDto.getMemberId())
                .password(signUpDto.getPassword())
                .nickname(signUpDto.getNickname())
                .phoneNumber(signUpDto.getPhoneNumber())
                .state(signUpDto.getState())
                .build();
    }
}
