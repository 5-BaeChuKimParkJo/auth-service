package com.chalnakchalnak.authservice.adapter.out.security;

import com.chalnakchalnak.authservice.application.port.out.AuthSecurityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthSecurityAdapter implements AuthSecurityPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
