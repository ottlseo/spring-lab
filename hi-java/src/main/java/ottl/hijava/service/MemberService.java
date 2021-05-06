package ottl.hijava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ottl.hijava.domain.Member;
import ottl.hijava.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service //스프링 빈 등록
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository){ //인자로 받도록-> Test코드에도 인자로 넣어줌
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
    */
    public Long join(Member member){

        validateDuplicateMember(member); //같은 이름이 있는 중복 회원 X
        memberRepository.save(member);
        return member.getId(); //id를 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(member1 -> { //이미 존재할 경우 (ifPresent)
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    public List<Member> findMembers(){
        return memberRepository.findAll(); //모든 회원 List 반환
    }
    public Optional<Member> findOne(Long memberId){ //한 회원 찾기
        return memberRepository.findById(memberId); //객체 반환
    }
    //public
}
