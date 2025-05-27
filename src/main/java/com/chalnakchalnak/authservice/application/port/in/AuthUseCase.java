package com.chalnakchalnak.authservice.application.port.in;


import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsByMemberIdRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsByNicknameRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.ExistsByPhoneNumberRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;

public interface AuthUseCase {

    void signUp(SignUpRequestDto signUpRequestDto);
    Boolean existsByMemberId(ExistsByMemberIdRequestDto existsByMemberIdRequestDto);
    Boolean existsByNickname(ExistsByNicknameRequestDto existsByNicknameRequestDto);
    Boolean existsByPhoneNumber(ExistsByPhoneNumberRequestDto existsByPhoneNumberRequestDto);
}
