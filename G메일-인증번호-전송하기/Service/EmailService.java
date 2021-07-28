package codic.ewhain.Service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;
//import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String ePw = createKey();

    private MimeMessage createMessage(String to)throws Exception{
        logger.info("보내는 대상 : "+ to);
        logger.info("인증 번호 : " + ePw);
        MimeMessage message = emailSender.createMimeMessage();

        try {
            String code = createCode(ePw);
            message.addRecipients(MimeMessage.RecipientType.TO, to); //보내는 대상
            message.setSubject("이화코딕 가입을 위한 인증 코드"); //제목

            String msg = "";
            msg += "<img width=\"120\" height=\"36\" style=\"margin-top: 0; margin-right: 0; margin-bottom: 32px; margin-left: 0px; padding-right: 30px; padding-left: 30px;\" src=\"https://slack.com/x-a1607371436052/img/slack_logo_240.png\" alt=\"\" loading=\"lazy\">";
            msg += "<h1 style=\"font-size: 30px; padding-right: 30px; padding-left: 30px;\">이메일 주소 확인</h1>";
            msg += "<p style=\"font-size: 17px; padding-right: 30px; padding-left: 30px;\">아래 확인 코드를 이화코딕 가입 창이 있는 브라우저 창에 입력하세요.</p>";
            msg += "<div style=\"padding-right: 30px; padding-left: 30px; margin: 32px 0 40px;\"><table style=\"border-collapse: collapse; border: 0; background-color: #F4F4F4; height: 70px; table-layout: fixed; word-wrap: break-word; border-radius: 6px;\"><tbody><tr><td style=\"text-align: center; vertical-align: middle; font-size: 30px;\">";
            msg += code;
            msg += "</td></tr></tbody></table></div>";
            msg += "<a href=\"https://slack.com\" style=\"text-decoration: none; color: #434245;\" rel=\"noreferrer noopener\" target=\"_blank\">Slack Clone Technologies, Inc</a>";

            message.setText(msg, "utf-8", "html"); //내용
            message.setFrom(new InternetAddress("보내는 계정", "ewha-codic")); //보내는 사람
        } catch (UnsupportedEncodingException e) {
            logger.error("Exception raised while sending message to " + to, e);
        }
        return message;
    }

    // 인증코드 만들기
    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 6자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    public void sendSimpleMessage(String to)throws Exception {
        MimeMessage message = createMessage(to);
        try{//예외처리
            emailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public String createCode(String ePw){
        return ePw.substring(0, 3) + "-" + ePw.substring(3, 6);
    }
}
