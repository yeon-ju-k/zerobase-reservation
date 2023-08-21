package com.zerobase.reservation.service;

import com.zerobase.reservation.model.entity.ClientEntity;
import com.zerobase.reservation.model.entity.PartnerEntity;
import com.zerobase.reservation.repository.ClientRepository;
import com.zerobase.reservation.repository.PartnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SignUpServiceTest {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    void 고객_회원가입_테스트() {
        //given
        ClientEntity clientEntity = ClientEntity.builder()
                .c_name("홍길동")
                .c_password("0")
                .c_email("test@naver.com")
                .c_phone("01000000000")
                .build();

        //when
        ClientEntity saved = clientRepository.save(clientEntity);

        //then
        Assertions.assertEquals(saved.getC_name(), "홍길동");

    }

    @Test
    void 관리자_회원가입_테스트() {
        //given
        PartnerEntity partnerEntity = PartnerEntity.builder()
                .p_email("test1@naver.com")
                .p_name("고길동")
                .p_phone("01011111111")
                .p_password("1")
                .build();

        //when
        PartnerEntity saved = partnerRepository.save(partnerEntity);

        //then
        Assertions.assertEquals(saved.getP_name(), "고길동");

    }

}