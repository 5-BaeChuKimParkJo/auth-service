package com.chalnakchalnak.authservice.adapter.in.web.presentation;

import com.chalnakchalnak.authservice.adapter.in.web.mapper.IdentityVerificationVoMapper;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.SendVerificationCodeRequestVo;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.VerifyCodeRequestVo;
import com.chalnakchalnak.authservice.application.port.in.IdentityVerificationUseCase;
import com.chalnakchalnak.authservice.adapter.in.common.entity.BaseResponseEntity;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/identity-verification")
@RequiredArgsConstructor
public class IdentityVerificationController {

    private final IdentityVerificationUseCase identityVerificationUseCase;
    private final IdentityVerificationVoMapper identityVerificationVoMapper;

    @Operation(summary = "Send Verification Code API", description = "인증 코드 전송 API", tags = {"Auth-service"})
    @PostMapping("/sms/send")
    public BaseResponseEntity<Void> sendVerificationCode(
            @RequestBody @Valid SendVerificationCodeRequestVo sendVerificationCodeRequestVo
    ) {

        identityVerificationUseCase.sendVerificationCode(
                identityVerificationVoMapper.toSendVerificationCodeDto(sendVerificationCodeRequestVo)
        );

        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS_SEND_VERIFICATION_CODE);
    }

    @Operation(summary = "Verify Code API", description = "인증 코드 검증 API", tags = {"Auth-service"})
    @PostMapping("/sms/verify")
    public BaseResponseEntity<Boolean> verifyCode(
            @RequestBody @Valid VerifyCodeRequestVo verifyCodeRequestVo
    ) {

        return new BaseResponseEntity<>(
                identityVerificationUseCase.verifyCode(
                        identityVerificationVoMapper.toVerifyCodeDto(verifyCodeRequestVo)
                )
        );
    }
}
