package ottl.hijava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ottl.hijava.domain.Member;

@Controller
public class HomeController {

    @GetMapping("/") //그냥 첫 화면
    public String home(){
        return "home";
    }
}
