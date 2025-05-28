package com.chalnakchalnak.authservice.application.port.in;

import com.chalnakchalnak.authservice.application.port.dto.in.ExistsMemberIdRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.ExistsPhoneNumberRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.SignInRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.out.SignInResponseDto;

public interface AuthUseCase {

    void signUp(SignUpRequestDto signUpRequestDto);
    Boolean existsMemberId(ExistsMemberIdRequestDto existsMemberIdRequestDto);
//    Boolean existsNickname(ExistsNicknameRequestDto existsNicknameRequestDto);
    Boolean existsPhoneNumber(ExistsPhoneNumberRequestDto existsPhoneNumberRequestDto);
    SignInResponseDto signIn(SignInRequestDto authSignInRequestDto);
}
