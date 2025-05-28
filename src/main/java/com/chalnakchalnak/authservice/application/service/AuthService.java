package com.chalnakchalnak.authservice.application.service;

import com.chalnakchalnak.authservice.application.port.dto.in.SignInRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.out.AuthResponseDto;
import com.chalnakchalnak.authservice.application.port.dto.out.SignInResponseDto;
import com.chalnakchalnak.authservice.domain.model.enums.IdentityVerificationPurpose;
import com.chalnakchalnak.authservice.application.mapper.AuthMapper;
import com.chalnakchalnak.authservice.application.port.in.AuthUseCase;
import com.chalnakchalnak.authservice.application.port.dto.in.ExistsMemberIdRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.ExistsPhoneNumberRequestDto;
import com.chalnakchalnak.authservice.application.port.dto.in.SignUpRequestDto;
import com.chalnakchalnak.authservice.application.port.out.AuthRepositoryPort;
import com.chalnakchalnak.authservice.application.port.out.AuthSecurityPort;
import com.chalnakchalnak.authservice.application.port.out.GenerateUuidPort;
import com.chalnakchalnak.authservice.application.port.out.VerificationCodeStorePort;
import com.chalnakchalnak.authservice.common.exception.BaseException;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import com.chalnakchalnak.authservice.domain.model.AuthDomain;
import jakarta.transaction.Transactional;
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
//    private final MemberServicePort memberServicePort;
//    private final MemberMapper memberMapper;

    @Override
    @Transactional
    public void signUp(SignUpRequestDto signUpRequestDto) {

        if (!verificationCodeStorePort.grantedAccess(
                signUpRequestDto.getPhoneNumber(), IdentityVerificationPurpose.SIGN_UP.toString())
        ) {
            throw new BaseException(BaseResponseStatus.SIGN_UP_NOT_VERIFIED);
        }

        if(authRepositoryPort.existsByMemberId(signUpRequestDto.getMemberId())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_MEMBER_ID);
//        } else if (memberServicePort.existsNickname(signUpRequestDto.getNickname())) {
//            throw new BaseException(BaseResponseStatus.DUPLICATED_NICKNAME);
        } else if (authRepositoryPort.existsByPhoneNumber(signUpRequestDto.getPhoneNumber())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PHONE_NUMBER);
        }

        AuthDomain authDomain = authMapper.toAuthDomain(
                signUpRequestDto,
                generateUuidPort.generateUuid(),
                authSecurityPort.encryptPassword(signUpRequestDto.getPassword())
        );

        authRepositoryPort.save(authMapper.toSignUpDto(authDomain));

        // member-service로 member 생성 요청 (feign client)
//        memberServicePort.createMember(memberMapper.toCreateMemberRequestDto(authDomain));
    }

    @Override
    public Boolean existsMemberId(ExistsMemberIdRequestDto existsMemberIdRequestDto) {
        return authRepositoryPort.existsByMemberId(existsMemberIdRequestDto.getMemberId());
    }

//    @Override
//    public Boolean existsNickname(ExistsNicknameRequestDto existsNicknameRequestDto) {
//        return authRepositoryPort.existsByNickname(existsNicknameRequestDto.getNickname());
//    }

    @Override
    public Boolean existsPhoneNumber(ExistsPhoneNumberRequestDto existsPhoneNumberRequestDto) {
        return authRepositoryPort.existsByPhoneNumber(existsPhoneNumberRequestDto.getPhoneNumber());
    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto authSignInRequestDto) {
        AuthResponseDto authResponseDto = authRepositoryPort.findByMemberId(authSignInRequestDto.getMemberId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.USER_NOT_FOUND)
        );

        AuthDomain authDomain = authMapper.toAuthDomain(authResponseDto);

        return authSecurityPort.signIn(
                authMapper.toSignInDto(authDomain), authSignInRequestDto.getPassword()
        );
    }

}
