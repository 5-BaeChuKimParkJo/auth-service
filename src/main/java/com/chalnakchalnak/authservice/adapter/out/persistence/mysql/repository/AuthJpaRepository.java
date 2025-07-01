package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.repository;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthJpaRepository extends JpaRepository<AuthEntity, String> {

    Boolean existsByMemberId(String memberId);
    Boolean existsByPhoneNumber(String phoneNumber);
    Optional<AuthEntity> findByMemberId(String memberId);
    Optional<AuthEntity> findMemberIdByPhoneNumber(String phoneNumber);
    Optional<AuthEntity> findByPhoneNumber(String phoneNumber);
}
