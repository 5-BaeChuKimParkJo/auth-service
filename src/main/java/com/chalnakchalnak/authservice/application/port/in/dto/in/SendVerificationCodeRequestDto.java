package com.chalnakchalnak.authservice.application.port.in.dto.in;

import com.chalnakchalnak.authservice.application.enums.IdentityVerificationPurpose;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendVerificationCodeRequestDto {

    private String phoneNumber;
    private IdentityVerificationPurpose purpose;

    @Builder
    public SendVerificationCodeRequestDto(
            String phoneNumber,
            IdentityVerificationPurpose purpose
    ) {
        this.phoneNumber = phoneNumber;
        this.purpose = purpose;
    }
}
