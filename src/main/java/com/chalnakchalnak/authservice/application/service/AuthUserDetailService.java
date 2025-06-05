package com.chalnakchalnak.authservice.application.service;

import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import com.chalnakchalnak.authservice.common.exception.BaseException;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class AuthUserDetailService implements UserDetailsService {

    private final AuthRepositoryPort authRepositoryPort;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        return authRepositoryPort.findByMemberId(memberId)
                .map(authResponseDto -> new User(authResponseDto.getMemberId(), authResponseDto.getPassword(), Collections.emptyList()))
                .orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_FOUND));
    }

}