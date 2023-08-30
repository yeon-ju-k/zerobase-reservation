package com.zerobase.reservation.application;

import com.zerobase.reservation.exception.CustomException;
import com.zerobase.reservation.exception.ErrorCode;
import com.zerobase.reservation.mailgun.MailgunClient;
import com.zerobase.reservation.mailgun.SendMailForm;
import com.zerobase.reservation.model.SignUpForm;
import com.zerobase.reservation.model.entity.ClientEntity;
import com.zerobase.reservation.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * 이메일 인증 + 회원가입
 */
@Service
@RequiredArgsConstructor
public class SignUpApplication {

    private final MailgunClient mailgunClient;
    private final SignUpService signUpService;  // 회원가입 service

    /**
     * 회원 인증 확인
     */
    public void clientVerify(String email, String code) {
        signUpService.verifyEmail(email, code);
    }


    /**
     * 회원가입
     */
    public String clientSignUp(SignUpForm form) {
        if (signUpService.isEmailExist(form.getEmail())) {
            // 이메일이 이미 존재할 경우 -> exception 발생
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);

        } else {
            ClientEntity c = signUpService.clientSignUp(form);  // 회원가입

            // 랜덤 코드 생성
            String code = getRandomCode();

            // SendMailForm
            SendMailForm sendMailForm = SendMailForm.builder()
                    .from("yeonjuminju@naver.com")
                    .to(c.getEmail())    // 가입하려는 email로 전송
                    .subject("Verification Email!")
                    .text(getVerificationEmailBody(c.getEmail(), c.getName(), code))
                    .build();

            // 이메일 전송
            mailgunClient.sendEmail(sendMailForm);

            // 인증 정보 업데이트, 인증 만료기한 설정
            signUpService.changeClientValidateEmail(c.getId(), code);

            return "회원가입에 성공하셨습니다.";
        }

    }


    /**
     * 랜덤 코드 생성
     */
    private String getRandomCode() {
        return RandomStringUtils.random(10, true, true);
    }


    /**
     * email 로 전송할 내용 양식
     */
    private String getVerificationEmailBody(String email, String name, String code) {
        StringBuilder builder = new StringBuilder();
        return builder.append("Hello")
                    .append(name)
                    .append("! Please Click Link for verification.\n\n")
                    // 클릭할 링크값 (이메일 인증)
                    .append("http://localhost:8080/signUp/verify/client?email=")
                    .append(email)
                    .append("&code=")
                    .append(code).toString();
    }

}


