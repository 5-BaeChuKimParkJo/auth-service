package com.chalnakchalnak.authservice.adapter.out.http.feign.member;

import com.chalnakchalnak.authservice.application.port.out.feign.member.MemberServicePort;

//@FeignClient(name = "member-service", url = "http://member-service.default.svc.cluster.local:8080")
public interface MemberServiceFeignClient extends MemberServicePort {

//    @PostMapping("/signup")
//    void createMember(@RequestBody CreateMemberRequestDto createMemberRequestDto);
//
//    @PostMapping("/exists/nickname")
//    Boolean existsNickname(@RequestBody String nickname);
}