package com.chalnakchalnak.authservice.application.port.out;

public interface VerificationCodeStorePort {

    void saveCode(String phoneNumber, String code);
    boolean isSendLimited(String phoneNumber);
    int increaseVerifyAttempt(String phoneNumber);
    void setGrantAccess(String purpose, String uuid);
    boolean hasGrantAccess(String purpose, String uuid);
    String findCode(String phoneNumber);
    void deleteCode(String phoneNumber);
    void deleteAttemptVerification(String phoneNumber);
}
