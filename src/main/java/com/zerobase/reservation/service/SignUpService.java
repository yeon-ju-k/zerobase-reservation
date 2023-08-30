package com.zerobase.reservation.service;

import com.zerobase.reservation.application.SignUpApplication;
import com.zerobase.reservation.exception.CustomException;
import com.zerobase.reservation.exception.ErrorCode;
import com.zerobase.reservation.model.SignUpForm;
import com.zerobase.reservation.model.entity.ClientEntity;
import com.zerobase.reservation.model.entity.PartnerEntity;
import com.zerobase.reservation.repository.ClientRepository;
import com.zerobase.reservation.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

import static com.zerobase.reservation.exception.ErrorCode.*;

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
     * # 2. 관리자 회원가입 기능 구현
     */
    public PartnerEntity partnerSignUp(SignUpForm form) {
        PartnerEntity partnerEntity = PartnerEntity.change(form);
        this.partnerRepository.save(partnerEntity);

        return partnerEntity;
    }


    /**
     * # 3. 회원가입 시 - Email 중복 여부 확인
     */
    public boolean isEmailExist(String email) {
        email = email.toLowerCase(Locale.ROOT);     // 중복확인을 위한 소문자 치환
        return clientRepository.existsByEmail(email);
    }


    /**
     * # 4. 이메일 인증 정보 업데이트 , 인증 만료시간 설정
     */
    @Transactional
    public LocalDateTime changeClientValidateEmail(Long clientId, String verificationCode) {
        Optional<ClientEntity> byId = clientRepository.findById(clientId);

        // 해당 id가 있을 경우
        if (byId.isPresent()) {
            ClientEntity clientEntity = byId.get();
            clientEntity.setVerificationCode(verificationCode);
            clientEntity.setVerifyExpiredAt(LocalDateTime.now().plusDays(1));

            return clientEntity.getVerifyExpiredAt();

        } else {  // 해당 id가 없을 경우 - 에러코드
            throw new CustomException(NOT_FOUND_USER);
        }
    }

    /**
     * # 5. 이메일 인증 확인
     */
    @Transactional
    public void verifyEmail(String email, String code) {
        ClientEntity client = clientRepository.findByEmail(email)
                .orElseThrow( () -> new CustomException(NOT_FOUND_USER));   // 비어있을 경우

        if (client.isVerify()) {    // 인증이 이미 되어있을 경우
            throw new CustomException(ALREADY_VERIFY);
        }
        else if (!client.getVerificationCode().equals(code)) {     // 인증 코드가 같지않을 경우
            throw new CustomException(WRONG_VERIFICATION);
        }
        else if (client.getVerifyExpiredAt().isBefore(LocalDateTime.now())) {   // 인증 코드가 만료 됐을 경우
            throw new CustomException(EXPIRE_VERIFICATION);
        }

        client.setVerify(true);

    }
}



