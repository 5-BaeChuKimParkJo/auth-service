package com.chalnakchalnak.authservice.adapter.in.web.mapper;

import com.chalnakchalnak.authservice.adapter.in.web.vo.in.*;
import com.chalnakchalnak.authservice.adapter.in.web.vo.out.SignInResponseVo;
import com.chalnakchalnak.authservice.application.port.dto.SignOutDto;
import com.chalnakchalnak.authservice.application.port.dto.in.*;
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

    public ExistsMemberIdRequestDto toExistsMemberIdRequestDto(String MemberId) {
        return ExistsMemberIdRequestDto.builder()
                .memberId(MemberId)
                .build();
    }

//    public ExistsNicknameRequestDto toExistsNicknameRequestDto(ExistsNicknameRequestVo existsNicknameRequestVo) {
//        return ExistsNicknameRequestDto.builder()
//                .nickname(existsNicknameRequestVo.getNickname())
//                .build();
//    }

    public ExistsPhoneNumberRequestDto toExistsPhoneNumberRequestDto(String phoneNumber) {
        return ExistsPhoneNumberRequestDto.builder()
                .phoneNumber(phoneNumber)
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

    public ReissueAllTokenRequestDto toReissueAllTokenRequestDto(String refreshToken) {
        return ReissueAllTokenRequestDto.builder()
                .refreshToken(refreshToken)
                .build();
    }

    public SignOutDto toSignOutDto(String refreshToken) {
        return SignOutDto.builder()
                .refreshToken(refreshToken)
                .build();
    }
}
