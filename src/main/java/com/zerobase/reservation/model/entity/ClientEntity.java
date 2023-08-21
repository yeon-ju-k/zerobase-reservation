package com.zerobase.reservation.model.entity;

import com.zerobase.reservation.model.SignUpForm;
import lombok.*;

import javax.persistence.*;

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
    private Long c_id;

    @Column(unique = true)
    private String c_email;

    private String c_name;
    private String c_password;
    private String c_phone;

    /**
     * SignUpFrom 타입을 -> ClientEntity 타입으로 변경
     */
    public static ClientEntity change(SignUpForm form) {
        return ClientEntity.builder()
                .c_email(form.getEmail())
                .c_name(form.getName())
                .c_password(form.getPassword())
                .c_phone(form.getPhone())
                .build();
    }
}
