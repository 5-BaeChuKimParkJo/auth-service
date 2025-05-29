package com.chalnakchalnak.authservice.adapter.out.sms.coolsms;

import com.chalnakchalnak.authservice.application.port.out.SmsPort;
import com.chalnakchalnak.authservice.common.exception.BaseException;
import com.chalnakchalnak.authservice.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoolSmsAdapter implements SmsPort {

    private final DefaultMessageService messageService;

    @Value("${coolsms.sender-phone-number}")
    private String senderPhoneNumber;
    public void sendSms(String phoneNumber, String Code) {
        Message message = new Message();
        message.setTo(phoneNumber);
        message.setFrom(senderPhoneNumber);
        message.setText("[찰낙찰낙]\n본인확인 인증번호 [" + Code + "]를 입력해주세요.");

        try {
            messageService.send(message);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_SEND_SMS);
        }
    }

}
