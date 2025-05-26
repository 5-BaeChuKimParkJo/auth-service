package com.chalnakchalnak.authservice.application.mapper;

import com.chalnakchalnak.authservice.application.port.in.dto.VerifyCodeRequestDto;
import com.chalnakchalnak.authservice.domain.model.IdentityVerificationDomain;
import org.springframework.stereotype.Component;

@Component
public class IdentityVerificationDtoMapper {

    public IdentityVerificationDomain toDomain(VerifyCodeRequestDto verifyCodeRequestDto) {
        return IdentityVerificationDomain.builder()
                .phoneNumber(verifyCodeRequestDto.getPhoneNumber())
                .verificationCode(verifyCodeRequestDto.getVerificationCode())
                .build();
    }
}
