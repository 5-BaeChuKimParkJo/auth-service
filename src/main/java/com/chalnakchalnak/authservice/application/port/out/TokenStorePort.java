package com.chalnakchalnak.authservice.application.port.out;

import com.chalnakchalnak.authservice.application.port.dto.StoreRefreshTokenDto;

public interface TokenStorePort {

    void saveRefreshToken(StoreRefreshTokenDto storeRefreshTokenDto);
    String getRefreshToken(String memberUuid);
    void deleteRefreshToken(String memberUuid);
}
