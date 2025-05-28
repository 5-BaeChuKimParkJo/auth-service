package com.chalnakchalnak.authservice.application.port.in.dto.in;

import com.chalnakchalnak.authservice.domain.model.enums.IdentityVerificationPurpose;
import lombok.Builder;
import lombok.Getter;

@Getter
public class VerifyCodeRequestDto {

    private String phoneNumber;
    private String verificationCode;
    private IdentityVerificationPurpose purpose;

    @Builder
    public VerifyCodeRequestDto(
            String phoneNumber,
            String verificationCode,
            IdentityVerificationPurpose purpose
    ) {
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
        this.purpose = purpose;
    }
}
