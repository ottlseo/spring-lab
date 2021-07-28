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

    @PostMapping("/verify")
    public String sendEmail(@RequestBody String id) throws Exception {
        String addr = id+"@ewhain.net";
        String code = emailService.createKey(); //인증코드 생성
        try{
            emailService.sendSimpleMessage(addr, code); //코드 보내주고
        } catch (Exception e){
            e.printStackTrace();
        }
        return code; //코드 프론트로 보내주기 -> 프론트에서 입력받은 값과 비교하여 인증
    }
}
