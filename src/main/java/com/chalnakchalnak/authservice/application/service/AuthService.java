package com.chalnakchalnak.authservice.application.service;

import com.chalnakchalnak.authservice.application.enums.IdentityVerificationPurpose;
import com.chalnakchalnak.authservice.application.mapper.AuthMapper;
import com.chalnakchalnak.authservice.application.port.in.AuthUseCase;
import com.chalnakchalnak.authservice.application.port.in.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import com.chalnakchalnak.authservice.application.port.out.AuthSecurityPort;
import com.chalnakchalnak.authservice.application.port.out.GenerateUuidPort;
import com.chalnakchalnak.authservice.application.port.out.VerificationCodeStorePort;
import com.chalnakchalnak.authservice.common.exception.BaseException;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import com.chalnakchalnak.authservice.domain.model.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final AuthRepositoryPort authRepositoryPort;
    private final AuthSecurityPort authSecurityPort;
    private final GenerateUuidPort generateUuidPort;
    private final VerificationCodeStorePort verificationCodeStorePort;
    private final AuthMapper authMapper;

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {

        if (verificationCodeStorePort.grantedAccess(signUpRequestDto.getPhoneNumber(), IdentityVerificationPurpose.SIGN_UP.toString())) {
            throw new BaseException(BaseResponseStatus.SIGN_UP_NOT_VERIFIED);
        }

        if(authRepositoryPort.existsByMemberId(signUpRequestDto.getMemberId())){
            throw new BaseException(BaseResponseStatus.DUPLICATED_MEMBER_ID);
        } else if (authRepositoryPort.existsByNickname(signUpRequestDto.getNickname())){
            throw new BaseException(BaseResponseStatus.DUPLICATED_NICKNAME);
        } else if (authRepositoryPort.existsByPhoneNumber(signUpRequestDto.getPhoneNumber())){
            throw new BaseException(BaseResponseStatus.DUPLICATED_PHONE_NUMBER);
        }

        MemberDomain memberDomain = authMapper.toMemberDomain(
                signUpRequestDto,
                generateUuidPort.generateUuid(),
                authSecurityPort.encryptPassword(signUpRequestDto.getPassword())
        );

        authRepositoryPort.save(authMapper.toSignUpDto(memberDomain));

    }


}
