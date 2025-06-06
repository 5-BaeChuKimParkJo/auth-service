package com.chalnakchalnak.authservice.application.mapper.feign;

import com.chalnakchalnak.authservice.application.port.dto.feign.member.CreateMemberRequestDto;
import com.chalnakchalnak.authservice.domain.model.AuthDomain;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public CreateMemberRequestDto toCreateMemberRequestDto(AuthDomain authDomain) {
        return CreateMemberRequestDto.builder()
                .memberUuid(authDomain.getMemberUuid())
                .nickname(authDomain.getNickname())
                .build();
    }
}
