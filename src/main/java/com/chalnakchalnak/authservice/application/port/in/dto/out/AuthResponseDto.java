package com.chalnakchalnak.authservice.application.port.in.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class AuthResponseDto {

    private String memberUuid;
    private String memberId;
    private String password;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public AuthResponseDto(
            String memberUuid,
            String memberId,
            String password,
            String phoneNumber,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.memberUuid = memberUuid;
        this.memberId = memberId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
