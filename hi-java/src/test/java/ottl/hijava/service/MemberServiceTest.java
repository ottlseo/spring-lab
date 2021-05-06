package ottl.hijava.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ottl.hijava.domain.Member;
import ottl.hijava.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository(); //여기서 객체 생성
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        //given :기본 설정
        Member member = new Member();
        member.setName("spring");

        //when :조건
        Long saveId = memberService.join(member);

        //then :결과 검증
        Member findMember = memberRepository.findById(saveId).get();
        org.junit.jupiter.api.Assertions.assertEquals(member.getName(), findMember.getName());
    }
    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); //예외가 발생해야 한다.

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    /*
        try{
            memberService.join(member2); //예외 터짐
            fail();
        } catch(IllegalStateException e){
            //정상 실행 된 경우임
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
 */
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}