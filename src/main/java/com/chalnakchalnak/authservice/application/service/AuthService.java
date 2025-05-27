package com.chalnakchalnak.authservice.application.service;

import com.chalnakchalnak.authservice.application.port.in.AuthUseCase;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import com.chalnakchalnak.authservice.application.port.out.AuthSecurityPort;
import com.chalnakchalnak.authservice.application.port.out.GenerateUuidPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final AuthRepositoryPort authRepositoryPort;
    private final AuthSecurityPort authSecurityPort;
    private final GenerateUuidPort generateUuidPort;

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {

    }


}
