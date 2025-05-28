package com.chalnakchalnak.authservice.application.port.out;

import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.in.dto.out.AuthResponseDto;

import java.util.Optional;

public interface AuthRepositoryPort {

    void save(SignUpDto signUpDto);
    Boolean existsByMemberId(String memberId);
//    Boolean existsByNickname(String nickname);
    Boolean existsByPhoneNumber(String phoneNumber);
    Optional<AuthResponseDto> findByMemberId(String memberId);

}
