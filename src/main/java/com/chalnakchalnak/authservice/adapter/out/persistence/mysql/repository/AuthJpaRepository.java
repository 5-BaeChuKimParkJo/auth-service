package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthJpaRepository extends JpaRepository<AuthEntity, String> {

    Boolean existsByMemberId(String memberId);
//    Boolean existsByNickname(String nickname);
    Boolean existsByPhoneNumber(String phoneNumber);
    AuthEntity findByMemberId(String memberId);
}
