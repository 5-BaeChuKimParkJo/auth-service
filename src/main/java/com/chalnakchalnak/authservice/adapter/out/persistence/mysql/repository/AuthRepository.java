package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.mapper.AuthEntityMapper;
import com.chalnakchalnak.authservice.application.port.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.dto.out.AuthResponseDto;
import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthRepository implements AuthRepositoryPort {

    private final AuthJpaRepository authJpaRepository;
    private final AuthEntityMapper authEntityMapper;

    @Override
    public void save(SignUpDto signUpDto) {
        authJpaRepository.save(authEntityMapper.toEntity(signUpDto));
    }

    @Override
    public Boolean existsByMemberId(String memberId) {
        return authJpaRepository.existsByMemberId(memberId);
    }

//    @Override
//    public Boolean existsByNickname(String nickname) {
//        return authJpaRepository.existsByNickname(nickname);
//    }

    @Override
    public Boolean existsByPhoneNumber(String phoneNumber) {
        return authJpaRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<AuthResponseDto> findByMemberId(String memberId) {
        return Optional.ofNullable(authEntityMapper.toAuthResponseDto(authJpaRepository.findByMemberId(memberId)));
    }
}
