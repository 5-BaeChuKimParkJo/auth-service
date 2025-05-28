package com.chalnakchalnak.authservice.application.port.out;

import com.chalnakchalnak.authservice.application.port.dto.SignInDto;
import com.chalnakchalnak.authservice.application.port.dto.out.SignInResponseDto;

public interface AuthSecurityPort {

    String encryptPassword(String password);
    SignInResponseDto signIn(SignInDto signInDto, String inputPassword);
}
