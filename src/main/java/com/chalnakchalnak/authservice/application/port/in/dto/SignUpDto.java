package com.chalnakchalnak.authservice.application.port.in.dto;

import com.chalnakchalnak.authservice.domain.model.enums.UserState;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpDto {

    private String memberUuid;
    private String memberId;
    private String password;
    private String nickname;
    private String phoneNumber;
    private UserState state;

    @Builder
    public SignUpDto(String memberUuid, String memberId, String password,
                     String nickname, String phoneNumber, UserState state) {
        this.memberUuid = memberUuid;
        this.memberId = memberId;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }

}
