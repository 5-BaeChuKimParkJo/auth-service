package com.chalnakchalnak.authservice.application.port.in;

import com.chalnakchalnak.authservice.application.port.in.dto.SendVerificationCodeRequestDto;
import com.chalnakchalnak.authservice.application.port.in.dto.VerifyCodeRequestDto;

public interface IdentityVerificationUseCase {

    void sendVerificationCode(SendVerificationCodeRequestDto sendVerificationCodeRequestDto);
    boolean verifyCode(VerifyCodeRequestDto verifyCodeRequestDto);
}
