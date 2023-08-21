package com.zerobase.reservation.controller;

import com.zerobase.reservation.model.SignUpForm;
import com.zerobase.reservation.model.entity.ClientEntity;
import com.zerobase.reservation.model.entity.PartnerEntity;
import com.zerobase.reservation.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    /**
     * 고객 회원가입 기능
     */
    @PostMapping("/client")
    public ResponseEntity<ClientEntity> clientSignUp(@RequestBody SignUpForm form) {
        ClientEntity saved = this.signUpService.clientSignUp(form);
        return ResponseEntity.ok(saved);
    }

    /**
     * 관리자(파트너) 회원가입 기능
     */
    @PostMapping("/partner")
    public ResponseEntity<PartnerEntity> partnerSignUp(@RequestBody SignUpForm form) {
        PartnerEntity saved = this.signUpService.partnerSignUp(form);
        return ResponseEntity.ok(saved);
    }
}
