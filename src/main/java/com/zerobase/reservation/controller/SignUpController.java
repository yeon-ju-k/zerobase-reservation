package com.zerobase.reservation.controller;

import com.zerobase.reservation.application.SignUpApplication;
import com.zerobase.reservation.model.SignUpForm;
import com.zerobase.reservation.model.entity.ClientEntity;
import com.zerobase.reservation.model.entity.PartnerEntity;
import com.zerobase.reservation.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpApplication signUpApplication;

    /**
     * 고객 회원가입 기능
     */
    @PostMapping("/client")
    public String clientSignUp(@RequestBody SignUpForm form) {
        return signUpApplication.clientSignUp(form);
    }


    /**
     * 관리자(파트너) 회원가입 기능
     */
    @PostMapping("/partner")
    public String partnerSignUp(@RequestBody SignUpForm form) {
        return null;
    }


    /**
     * 회원 가입 이메일 인증
     */
    @GetMapping("/verify/client")
    public ResponseEntity<String> verifyClient(@RequestParam String email, @RequestParam String code) {
        signUpApplication.clientVerify(email, code);

       return ResponseEntity.ok("인증이 완료되었습니다.");
    }


}
