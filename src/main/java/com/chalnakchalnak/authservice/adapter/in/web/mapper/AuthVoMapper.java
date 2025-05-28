package com.chalnakchalnak.authservice.adapter.in.web.mapper;

import com.chalnakchalnak.authservice.adapter.in.web.vo.in.ExistsMemberIdRequestVo;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.ExistsNicknameRequestVo;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.ExistsPhoneNumberRequestVo;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.SignUpRequestVo;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsMemberIdRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsNicknameRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsPhoneNumberRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AuthVoMapper {

    public SignUpRequestDto toSignUpRequestDto(SignUpRequestVo signUpRequestVo) {
        return SignUpRequestDto.builder()
                .memberId(signUpRequestVo.getMemberId())
                .password(signUpRequestVo.getPassword())
                .nickname(signUpRequestVo.getNickname())
                .phoneNumber(signUpRequestVo.getPhoneNumber())
                .build();
    }

    public ExistsMemberIdRequestDto toExistsMemberIdRequestDto(ExistsMemberIdRequestVo existsMemberIdRequestVo) {
        return ExistsMemberIdRequestDto.builder()
                .memberId(existsMemberIdRequestVo.getMemberId())
                .build();
    }

    public ExistsNicknameRequestDto toExistsNicknameRequestDto(ExistsNicknameRequestVo existsNicknameRequestVo) {
        return ExistsNicknameRequestDto.builder()
                .nickname(existsNicknameRequestVo.getNickname())
                .build();
    }

    public ExistsPhoneNumberRequestDto toExistsPhoneNumberRequestDto(ExistsPhoneNumberRequestVo existsPhoneNumberRequestVo) {
        return ExistsPhoneNumberRequestDto.builder()
                .phoneNumber(existsPhoneNumberRequestVo.getPhoneNumber())
                .build();
    }

}
