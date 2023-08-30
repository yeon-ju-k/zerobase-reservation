package com.zerobase.reservation.service;

import com.zerobase.reservation.mailgun.MailgunClient;
import com.zerobase.reservation.mailgun.SendMailForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * mailgun 으로 이메일 전송 service
 */

@Service
@RequiredArgsConstructor
public class EmailSendService {

    private final MailgunClient mailgunClient;

    public ResponseEntity<String> sendMail() {

        SendMailForm form = SendMailForm.builder()
                .from("yeonjuminju@gmail.com")
                .to("yeonjuminju@naver.com")
                .subject("123")
                .text("123")
                .build();

        ResponseEntity<String> response = mailgunClient.sendEmail(form);
        return response;
    }

}
