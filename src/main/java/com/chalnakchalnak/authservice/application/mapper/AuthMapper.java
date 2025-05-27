package com.chalnakchalnak.authservice.application.mapper;

import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.domain.model.MemberDomain;
import com.chalnakchalnak.authservice.domain.model.enums.UserState;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public MemberDomain toMemberDomain(SignUpRequestDto signUpRequestDto, String uuid, String hashedPassword) {
        return MemberDomain.builder()
                .memberUuid(uuid)
                .memberId(signUpRequestDto.getMemberId())
                .password(hashedPassword)
                .nickname(signUpRequestDto.getNickname())
                .phoneNumber(signUpRequestDto.getPhoneNumber())
                .state(UserState.ACTIVE)
                .build();
    }

    public SignUpDto toSignUpDto(MemberDomain memberDomain) {
        return SignUpDto.builder()
                .memberUuid(memberDomain.getMemberUuid())
                .memberId(memberDomain.getMemberId())
                .password(memberDomain.getPassword())
                .nickname(memberDomain.getNickname())
                .phoneNumber(memberDomain.getPhoneNumber())
                .state(memberDomain.getState())
                .build();
    }

}
