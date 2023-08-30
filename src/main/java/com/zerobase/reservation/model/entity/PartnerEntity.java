package com.zerobase.reservation.model.entity;

import com.zerobase.reservation.model.SignUpForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 관리자(파트너) 회원 테이블 Entity
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;
    private String phone;

    // 이메일 인증 코드를 위한 필드
    private LocalDateTime verifyExpiredAt;
    private String verificationCode;
    private boolean verify;


    /**
     * SignUpForm 타입을 -> PartnerEntity 타입으로 변경
     */
    public static PartnerEntity change(SignUpForm form) {
        PartnerEntity partnerEntity = PartnerEntity.builder()
                .email(form.getEmail())
                .name(form.getName())
                .phone(form.getPhone())
                .password(form.getPassword())
                .build();
        return partnerEntity;
    }

}
