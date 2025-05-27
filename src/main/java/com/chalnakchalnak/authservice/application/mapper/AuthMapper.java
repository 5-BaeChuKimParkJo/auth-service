package com.chalnakchalnak.authservice.application.mapper;

import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import com.chalnakchalnak.authservice.domain.model.MemberDomain;
import com.chalnakchalnak.authservice.domain.model.enums.UserState;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public MemberDomain toMemberDomain(SignUpDto signUpDto, String uuid, String hashedPassword) {
        return MemberDomain.builder()
                .memberUuid(uuid)
                .memberId(signUpDto.getMemberId())
                .password(hashedPassword)
                .nickname(signUpDto.getNickname())
                .phoneNumber(signUpDto.getPhoneNumber())
                .state(UserState.ACTIVE)
                .build();
    }


}
