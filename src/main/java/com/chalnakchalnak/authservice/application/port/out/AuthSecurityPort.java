package com.chalnakchalnak.authservice.application.port.out;

public interface AuthSecurityPort {

    String encryptPassword(String password);
}
