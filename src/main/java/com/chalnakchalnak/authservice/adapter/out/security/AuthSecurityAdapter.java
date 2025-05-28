package com.chalnakchalnak.authservice.adapter.out.security;

import com.chalnakchalnak.authservice.adapter.out.security.provider.JwtTokenProvider;
import com.chalnakchalnak.authservice.application.mapper.AuthMapper;
import com.chalnakchalnak.authservice.application.port.dto.SignInDto;
import com.chalnakchalnak.authservice.application.port.dto.out.SignInResponseDto;
import com.chalnakchalnak.authservice.application.port.out.AuthSecurityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthSecurityAdapter implements AuthSecurityPort {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;

    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public SignInResponseDto signIn(SignInDto signInDto, String inputPassword) {
        if(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInDto.getMemberId(),
                        inputPassword
                )
        ).isAuthenticated()) {
            return authMapper.toSignInResponseDto(
                    jwtTokenProvider.generateAccessToken("member", signInDto.getMemberUuid()),
                    jwtTokenProvider.generateRefreshToken("member", signInDto.getMemberUuid())
            );
        } else {
            throw new RuntimeException("Failed to login");
        }
    }

}
