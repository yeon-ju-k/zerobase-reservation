package com.zerobase.reservation.model.entity;

import com.zerobase.reservation.model.SignUpForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 고객 회원 테이블 entity
 */

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

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
     * SignUpFrom 타입을 -> ClientEntity 타입으로 변경
     */
    public static ClientEntity change(SignUpForm form) {
        return ClientEntity.builder()
                .email(form.getEmail())
                .name(form.getName())
                .password(form.getPassword())
                .phone(form.getPhone())
                .build();
    }
}
