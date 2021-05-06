package ottl.hijava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ottl.hijava.domain.Member;
import ottl.hijava.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService; //memberService와 연결하려고

    @Autowired //자동으로 연결 (DI)
    public MemberController(MemberService memberService){
        this.memberService = memberService; //이 컨트롤러와 memberService 연결
    }
    @GetMapping("/members/new") // 홈 화면에서 이동할 페이지와 연동
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); //인자로 받은 form의 값을 멤버 객체의 이름으로 set

        memberService.join(member); //회원가입

        return "redirect:/";
    }
    @GetMapping(value = "/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //모든 멤버 찾아와 리스트로 저장
        model.addAttribute("members",members); //model에 저장
        return "members/memberList"; //템플릿으로 보냄
    }

}
