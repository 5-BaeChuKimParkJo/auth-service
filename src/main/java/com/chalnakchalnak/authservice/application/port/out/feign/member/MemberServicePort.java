package com.chalnakchalnak.authservice.application.port.out.feign.member;

import com.chalnakchalnak.authservice.application.port.dto.feign.member.CreateMemberRequestDto;

public interface MemberServicePort {

    void createMember(CreateMemberRequestDto createMemberRequestDto);

    Boolean existsByNickname(String nickname);
}
