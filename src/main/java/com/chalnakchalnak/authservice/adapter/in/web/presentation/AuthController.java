package com.chalnakchalnak.authservice.adapter.in.web.presentation;

import com.chalnakchalnak.authservice.adapter.in.web.mapper.AuthVoMapper;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.*;
import com.chalnakchalnak.authservice.adapter.in.web.vo.out.SignInResponseVo;
import com.chalnakchalnak.authservice.application.port.in.AuthUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;
    private final AuthVoMapper authVoMapper;

    @Operation(summary = "Sign Up API", description = "회원가입", tags = {"auth"})
    @PostMapping("/sign-up")
    public void signUp(@RequestBody @Valid SignUpRequestVo signUpRequestVo) {

        authUseCase.signUp(authVoMapper.toSignUpRequestDto(signUpRequestVo));
    }

    @Operation(summary = "Check Member ID API", description = "회원 아이디 중복 확인", tags = {"auth"})
    @GetMapping("/exists/member-id/{memberId}")
    public Boolean existsMemberId(
            @PathVariable("memberId") String memberId
    ) {

        return authUseCase.existsMemberId(authVoMapper.toExistsMemberIdRequestDto(memberId));
    }

//    @GetMapping("/exists/nickname")
//    public BaseResponseEntity<Boolean> existsNickname(
//            @RequestBody @Valid ExistsNicknameRequestVo existsNicknameRequestVo
//    ) {
//
//        return new BaseResponseEntity<>(authUseCase.existsNickname(
//                authVoMapper.toExistsNicknameRequestDto(existsNicknameRequestVo))
//        );
//    }

    @Operation(summary = "Check Nickname API", description = "닉네임 중복 확인", tags = {"auth"})
    @GetMapping("/exists/phone-number/{phoneNumber}")
    public Boolean existsPhoneNumber(
            @PathVariable("phoneNumber") String phoneNumber
    ) {

        return authUseCase.existsPhoneNumber(authVoMapper.toExistsPhoneNumberRequestDto(phoneNumber));
    }

    @Operation(summary = "Sign In API", description = "로그인", tags = {"auth"})
    @PostMapping("/sign-in")
    public SignInResponseVo signIn(
            @RequestBody @Valid SignInRequestVo signInRequestVo
            ) {

        return authVoMapper.toSignInResponseVo(authUseCase.signIn(authVoMapper.toSignInRequestDto(signInRequestVo)));
    }

    @Operation(summary = "Reissue Token API", description = "토큰 재발급", tags = {"auth"})
    @GetMapping("/reissue")
    public SignInResponseVo reissueAllToken(
            @RequestHeader("Authorization") String refreshToken
    ) {

        return authVoMapper.toSignInResponseVo(authUseCase.reissueAllToken(
                        authVoMapper.toReissueAllTokenRequestDto(refreshToken.substring(7))));
    }

    @Operation(summary = "Sign Out API", description = "로그아웃", tags = {"auth"})
    @GetMapping("/sign-out")
    public void signOut(
            @RequestHeader("Authorization") String refreshToken
    ) {

        authUseCase.signOut(authVoMapper.toSignOutDto(refreshToken.substring(7)));
    }
}
