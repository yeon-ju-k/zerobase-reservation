package com.zerobase.reservation.model;

import lombok.Getter;

import java.util.Date;

/**
 * 회원가입 폼 - 고객, 관리자(파트너)
 */

@Getter
public class SignUpForm {

    private String email;
    private String name;
    private String password;
    private String phone;

}
