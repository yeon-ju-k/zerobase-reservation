package com.zerobase.reservation.model.entity;

import com.zerobase.reservation.model.SignUpForm;
import lombok.*;

import javax.persistence.*;

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
    private Long p_id;

    @Column(unique = true)
    private String p_email;

    private String p_name;
    private String p_password;
    private String p_phone;

    /**
     * SignUpForm 타입을 -> PartnerEntity 타입으로 변경
     */
    public static PartnerEntity change(SignUpForm form) {
        PartnerEntity partnerEntity = PartnerEntity.builder()
                .p_email(form.getEmail())
                .p_name(form.getName())
                .p_phone(form.getPhone())
                .p_password(form.getPassword())
                .build();
        return partnerEntity;
    }
}
