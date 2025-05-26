package com.chalnakchalnak.authservice.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IdentityVerificationDomain {
    private String phoneNumber;
    private String verificationCode;

    @Builder
    public IdentityVerificationDomain(String phoneNumber, String verificationCode) {
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
    }

    public boolean verifyCode(String storedCode) {
        return this.verificationCode.equals(storedCode);
    }
}
