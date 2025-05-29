package com.chalnakchalnak.authservice.adapter.in.web.presentation;


import com.chalnakchalnak.authservice.adapter.in.common.entity.BaseResponseEntity;
import com.chalnakchalnak.authservice.adapter.in.web.mapper.AuthVoMapper;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.*;
import com.chalnakchalnak.authservice.adapter.in.web.vo.out.SignInResponseVo;
import com.chalnakchalnak.authservice.application.port.in.AuthUseCase;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/exists/member-id/{memberId}")
    public BaseResponseEntity<Boolean> existsMemberId(
            @PathVariable("memberId") String memberId
    ) {

        return new BaseResponseEntity<>(
                authUseCase.existsMemberId(authVoMapper.toExistsMemberIdRequestDto(memberId))
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

    @PostMapping("/exists/phone-number/{phoneNumber}")
    public BaseResponseEntity<Boolean> existsPhoneNumber(
            @PathVariable("phoneNumber") String phoneNumber
    ) {

        return new BaseResponseEntity<>(
                authUseCase.existsPhoneNumber(authVoMapper.toExistsPhoneNumberRequestDto(phoneNumber))
        );
    }

    @PostMapping("/sign-in")
    public BaseResponseEntity<SignInResponseVo> signIn(
            @RequestBody @Valid SignInRequestVo signInRequestVo
            ) {

        return new BaseResponseEntity<>(
                authVoMapper.toSignInResponseVo(authUseCase.signIn(authVoMapper.toSignInRequestDto(signInRequestVo)))
        );
    }

    @GetMapping("/reissue")
    public BaseResponseEntity<SignInResponseVo> reissueAllToken(
            @RequestHeader("Authorization") String refreshToken
    ) {

        return new BaseResponseEntity<>(
                authVoMapper.toSignInResponseVo(authUseCase.reissueAllToken(
                        authVoMapper.toReissueAllTokenRequestDto(refreshToken.substring(7))))
        );
    }

    @GetMapping("/sign-out")
    public BaseResponseEntity<Void> signOut(
            @RequestHeader("Authorization") String refreshToken
    ) {

        authUseCase.signOut(authVoMapper.toSignOutDto(refreshToken.substring(7)));

        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS_SIGN_OUT);
    }
}
