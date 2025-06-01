package com.chalnakchalnak.authservice.application.port.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResetPasswordRequestDto {

    private String phoneNumber;
    private String newPassword;
    private String confirmPassword;

    @Builder
    public ResetPasswordRequestDto(String phoneNumber, String newPassword, String confirmPassword) {
        this.phoneNumber = phoneNumber;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }
}
