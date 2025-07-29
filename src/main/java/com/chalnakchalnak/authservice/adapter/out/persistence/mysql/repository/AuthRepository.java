package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity.AuthEntity;
import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.mapper.AuthEntityMapper;
import com.chalnakchalnak.authservice.application.port.dto.GetMemberIdDto;
import com.chalnakchalnak.authservice.application.port.dto.SignUpDto;
import com.chalnakchalnak.authservice.application.port.dto.out.AuthResponseDto;
import com.chalnakchalnak.authservice.application.port.dto.out.GetMemberIdResponseDto;
import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import com.chalnakchalnak.authservice.common.exception.BaseException;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import jakarta.transaction.Transactional;
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

        return authJpaRepository.findByMemberId(memberId)
                .map(authEntityMapper::toAuthResponseDto);
    }

    @Override
    public Optional<GetMemberIdResponseDto> findMemberIdByPhoneNumber(GetMemberIdDto getMemberIdDto) {

        return authJpaRepository.findMemberIdByPhoneNumber(getMemberIdDto.getPhoneNumber())
                .map(authEntityMapper::toGetMemberIdResponseDto);
    }

    @Override
    @Transactional
    public void resetPassword(String phoneNumber, String encryptedPassword) {
        AuthEntity authEntity = authJpaRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_FOUND));

        authEntity.resetPassword(encryptedPassword);
    }
}
