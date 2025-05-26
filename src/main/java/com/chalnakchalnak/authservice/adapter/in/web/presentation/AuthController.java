package com.chalnakchalnak.authservice.adapter.in.web.presentation;


import com.chalnakchalnak.authservice.adapter.in.common.entity.BaseResponseEntity;
import com.chalnakchalnak.authservice.adapter.in.web.mapper.AuthVoMapper;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.SignUpRequestVo;
import com.chalnakchalnak.authservice.application.port.in.AuthUseCase;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;
    private final AuthVoMapper authVoMapper;

    @PostMapping("/sign-up")
    public BaseResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequestVo signUpRequestVo) {
        authUseCase.signUp(authVoMapper.toSignUpRequestDto(signUpRequestVo));

        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS_SIGN_UP);
    }
}
