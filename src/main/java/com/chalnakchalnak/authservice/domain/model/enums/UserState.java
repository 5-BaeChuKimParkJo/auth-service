package com.chalnakchalnak.authservice.domain.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserState {

    WITHDRAWAL_PENDING("탈퇴예정"),
    ACTIVE("활성화");

    private final String label;
}
