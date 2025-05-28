package com.chalnakchalnak.authservice.adapter.in.web.presentation;

import com.chalnakchalnak.authservice.adapter.in.web.mapper.IdentityVerificationVoMapper;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.SendVerificationCodeRequestVo;
import com.chalnakchalnak.authservice.adapter.in.web.vo.in.VerifyCodeRequestVo;
import com.chalnakchalnak.authservice.application.port.in.IdentityVerificationUseCase;
import com.chalnakchalnak.authservice.adapter.in.common.entity.BaseResponseEntity;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
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

    @PostMapping("/sms/send")
    public BaseResponseEntity<Void> sendVerificationCode(
            @RequestBody @Valid SendVerificationCodeRequestVo sendVerificationCodeRequestVo
    ) {

        identityVerificationUseCase.sendVerificationCode(
                identityVerificationVoMapper.toSendVerificationCodeDto(sendVerificationCodeRequestVo)
        );

        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS_SEND_VERIFICATION_CODE);
    }

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
