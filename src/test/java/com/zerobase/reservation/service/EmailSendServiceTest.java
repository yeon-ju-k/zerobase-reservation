package com.zerobase.reservation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailSendServiceTest {

    @Autowired
    private EmailSendService emailSendService;


    @Test
    void test() {
        //given
        emailSendService.sendMail();

        //when
        //then

    }

}