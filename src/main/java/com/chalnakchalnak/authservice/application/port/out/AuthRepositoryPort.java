package com.chalnakchalnak.authservice.application.port.out;

import com.chalnakchalnak.authservice.application.port.in.dto.SignUpDto;

public interface AuthRepositoryPort {

    void save(SignUpDto signUpDto);
}
