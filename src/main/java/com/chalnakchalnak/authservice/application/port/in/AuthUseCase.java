package com.chalnakchalnak.authservice.application.port.in;


import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;

public interface AuthUseCase {

    void signUp(SignUpRequestDto signUpRequestDto);
}
