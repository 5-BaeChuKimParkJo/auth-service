package com.chalnakchalnak.authservice.application.port.out;

public interface SmsPort {

    void sendSms(String phoneNumber, String code);
}
