//package com.chalnakchalnak.authservice.adapter.out.http.feign.member;
//
//import com.chalnakchalnak.authservice.adapter.out.http.feign.member.client.MemberServiceFeignClient;
//import com.chalnakchalnak.authservice.application.port.dto.feign.member.CreateMemberRequestDto;
//import com.chalnakchalnak.authservice.application.port.out.feign.member.MemberServicePort;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class MemberServiceFeignAdapter implements MemberServicePort {
//
//    private final MemberServiceFeignClient memberServiceFeignClient;
//
//    @Override
//    public void createMember(CreateMemberRequestDto dto) {
//        memberServiceFeignClient.createMember(dto);
//    }
//
//    @Override
//    public Boolean existsByNickname(String nickname) {
//        return memberServiceFeignClient.existsByNickname(nickname);
//    }
//}