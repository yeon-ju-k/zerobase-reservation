package com.zerobase.reservation.service;

import com.zerobase.reservation.model.SignUpForm;
import com.zerobase.reservation.model.entity.ClientEntity;
import com.zerobase.reservation.model.entity.PartnerEntity;
import com.zerobase.reservation.repository.ClientRepository;
import com.zerobase.reservation.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 고객 회원가입 서비스
 */

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final ClientRepository clientRepository;
    private final PartnerRepository partnerRepository;

    /**
     * # 1. 고객 회원가입 기능 구현
     */
    public ClientEntity clientSignUp(SignUpForm form) {
        ClientEntity clientEntity = ClientEntity.change(form);
        clientRepository.save(clientEntity);

        return clientEntity;
    }


    /**
     *  # 2. 관리자 회원가입 기능 구현
     */
    public PartnerEntity partnerSignUp(SignUpForm form) {
        PartnerEntity partnerEntity = PartnerEntity.change(form);
        this.partnerRepository.save(partnerEntity);

        return partnerEntity;
    }

}
