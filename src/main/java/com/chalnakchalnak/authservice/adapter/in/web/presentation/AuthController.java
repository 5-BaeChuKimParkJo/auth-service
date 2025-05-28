package com.chalnakchalnak.authservice.adapter.in.web.presentation;


import com.chalnakchalnak.authservice.adapter.in.common.entity.BaseResponseEntity;
import com.chalnakchalnak.authservice.adapter.in.web.mapper.AuthVoMapper;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.*;
import com.chalnakchalnak.authservice.adapter.in.web.vo.out.SignInResponseVo;
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

    @PostMapping("/exists/member-id")
    public BaseResponseEntity<Boolean> existsMemberId(
            @RequestBody @Valid ExistsMemberIdRequestVo existsMemberIdRequestVo
    ) {

        return new BaseResponseEntity<>(
                authUseCase.existsMemberId(authVoMapper.toExistsMemberIdRequestDto(existsMemberIdRequestVo))
        );
    }

//    @PostMapping("/exists/nickname")
//    public BaseResponseEntity<Boolean> existsNickname(
//            @RequestBody @Valid ExistsNicknameRequestVo existsNicknameRequestVo
//    ) {
//
//        return new BaseResponseEntity<>(authUseCase.existsNickname(
//                authVoMapper.toExistsNicknameRequestDto(existsNicknameRequestVo))
//        );
//    }

    @PostMapping("/exists/phone-number")
    public BaseResponseEntity<Boolean> existsPhoneNumber(
            @RequestBody @Valid ExistsPhoneNumberRequestVo existsPhoneNumberRequestVo
    ) {

        return new BaseResponseEntity<>(
                authUseCase.existsPhoneNumber(authVoMapper.toExistsPhoneNumberRequestDto(existsPhoneNumberRequestVo))
        );
    }

    @PostMapping("sign-in")
    public BaseResponseEntity<SignInResponseVo> signIn(
            @RequestBody @Valid SignInRequestVo signInRequestVo
            ) {

        return new BaseResponseEntity<>(
                authVoMapper.toSignInResponseVo(authUseCase.signIn(authVoMapper.toSignInRequestDto(signInRequestVo)))
        );
    }
}
