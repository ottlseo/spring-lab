package ottl.hijava.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {
    @GetMapping("hi")
    public String hi(Model model){
        model.addAttribute("data","yoonseo :)");
        return "hi";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string") //ResponseBody- 문자 리턴할 경우
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //"hello spring" 그대로 바디에 전달됨(html이 아니라 문자열 자체로)
    }

    @GetMapping("hello-api") //ResponseBody- 객체 리턴할 경우: json 방식 이용
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ //json --> {key:value}방식

        Hello hello = new Hello(); //객체 생성
        hello.setName(name);
        return hello; //처음으로 객체를 리턴함

    }

    static class Hello{ //클래스와 자바 api 정의 (getter, setter)
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }
}
