package com.chalnakchalnak.authservice.adapter.in.web.mapper;

import com.chalnakchalnak.authservice.adapter.in.web.vo.in.*;
import com.chalnakchalnak.authservice.adapter.in.web.vo.out.SignInResponseVo;
import com.chalnakchalnak.authservice.application.port.dto.in.ExistsMemberIdRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.ExistsPhoneNumberRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.SignInRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.out.SignInResponseDto;
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

//    public ExistsNicknameRequestDto toExistsNicknameRequestDto(ExistsNicknameRequestVo existsNicknameRequestVo) {
//        return ExistsNicknameRequestDto.builder()
//                .nickname(existsNicknameRequestVo.getNickname())
//                .build();
//    }

    public ExistsPhoneNumberRequestDto toExistsPhoneNumberRequestDto(ExistsPhoneNumberRequestVo existsPhoneNumberRequestVo) {
        return ExistsPhoneNumberRequestDto.builder()
                .phoneNumber(existsPhoneNumberRequestVo.getPhoneNumber())
                .build();
    }

    public SignInRequestDto toSignInRequestDto(SignInRequestVo signInRequestVo) {
        return SignInRequestDto.builder()
                .memberId(signInRequestVo.getMemberId())
                .password(signInRequestVo.getPassword())
                .build();
    }

    public SignInResponseVo toSignInResponseVo(SignInResponseDto signInResponseDto) {
        return SignInResponseVo.builder()
                .accessToken(signInResponseDto.getAccessToken())
                .refreshToken(signInResponseDto.getRefreshToken())
                .build();
    }

}
