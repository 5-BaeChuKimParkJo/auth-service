package com.chalnakchalnak.authservice.application.port.in;

import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsMemberIdRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsNicknameRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsPhoneNumberRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;

public interface AuthUseCase {

    void signUp(SignUpRequestDto signUpRequestDto);
    Boolean existsMemberId(ExistsMemberIdRequestDto existsMemberIdRequestDto);
//    Boolean existsNickname(ExistsNicknameRequestDto existsNicknameRequestDto);
    Boolean existsPhoneNumber(ExistsPhoneNumberRequestDto existsPhoneNumberRequestDto);
}
