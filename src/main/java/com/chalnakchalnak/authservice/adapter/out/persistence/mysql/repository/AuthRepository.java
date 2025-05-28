package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.mapper.AuthEntityMapper;
import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
