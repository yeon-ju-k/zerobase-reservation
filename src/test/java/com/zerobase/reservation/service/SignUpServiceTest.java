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
                .name("홍길동")
                .password("0")
                .email("test@naver.com")
                .phone("01000000000")
                .build();

        //when
        ClientEntity saved = clientRepository.save(clientEntity);

        //then
        Assertions.assertEquals(saved.getName(), "홍길동");

    }

    @Test
    void 관리자_회원가입_테스트() {
        //given
        PartnerEntity partnerEntity = PartnerEntity.builder()
                .email("test1@naver.com")
                .name("고길동")
                .phone("01011111111")
                .password("1")
                .build();

        //when
        PartnerEntity saved = partnerRepository.save(partnerEntity);

        //then
        Assertions.assertEquals(saved.getName(), "고길동");

    }

}