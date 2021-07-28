package codic.ewhain.Controller;

import codic.ewhain.Service.EmailService;
import codic.ewhain.dto.EmailCodeDto;
import codic.ewhain.dto.EmailDto;
import codic.ewhain.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/email", method = {RequestMethod.GET, RequestMethod.POST},
        produces = "application/json; charset=UTF-8")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDto email) throws Exception {
        String id = URLEncoder.encode(email.getId() , "UTF-8"); //id가 null
        try{
            String addr = id+"@ewhain.net";
            emailService.sendSimpleMessage(addr);
            return "true";
        } catch (Exception e){
            return email.getId();
        }
    }
    /*
    @PostMapping("/verify")
    public ResponseEntity<ResponseDto> verifyCode(@RequestBody EmailCodeDto code) {
        Long userId = emailService.getUserIdByCode(code.getCode());
        return ResponseEntity.ok(ResponseDto.of(HttpStatus.OK, EMAIL_AUTH_SUCCESS, jwtIssueService.createAccessToken(new JwtPayload(userId))));
    }
    @RequestMapping(value = "/email", method = {RequestMethod.GET, RequestMethod.POST}) // 이메일 인증 코드 보내기
    public boolean emailAuth(@PathVariable("id") String id) throws Exception {
        String email = id+"@ewhain.net";
        emailService.sendSimpleMessage(email);

        return true;
    }

    @PostMapping("/verifyCode/{code}") // 이메일 인증 코드 검증
    public boolean verifyCode(@PathVariable("code") String code) {
        if(EmailService.ePw.equals(code)) {
            return true;
        }
        else{
            return false;
        }
    }

     */
}