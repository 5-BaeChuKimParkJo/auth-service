package com.chalnakchalnak.authservice.adapter.out.persistence.mysql.entity;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.common.BaseEntity;
import com.chalnakchalnak.authservice.domain.model.enums.UserState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "member_uuid", unique = true, nullable = false, length = 50)
    private String memberUuid;

    @Column(name = "member_id", unique = true, nullable = false, length = 100)
    private String memberId;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "nickname", unique = true, nullable = false, length = 50)
    private String nickname;

    @Column(name = "phone_number", unique = true, nullable = false, length = 20)
    private String phoneNumber;

//    @Column(name = "grade_name", nullable = false, length = 50)
//    private String gradeName;
//
//    @Column(name = "honor_name", nullable = false, length = 50)
//    private String honorName;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false, length = 20)
    private UserState state;

    @Builder
    public MemberEntity(String memberUuid, String memberId, String password,
                        String nickname, String phoneNumber, UserState state) {
        this.memberUuid = memberUuid;
        this.memberId = memberId;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }
}
