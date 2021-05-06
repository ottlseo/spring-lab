/* 스프링 컨테이너와 DB까지 연결한 통합 테스트 */
package ottl.hijava.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ottl.hijava.domain.Member;
import ottl.hijava.repository.MemberRepository;
//import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        // Given
        Member member = new Member();
        member.setName("yoonse");
            /*기존에 DB에 있는 이름이라도 테스트니까 상관없음 (@Transactional 덕분임) */

        // When
        Long saveId = memberService.join(member); //yoonseo를 회원가입 시킨다

        // Then
        Member findMember = memberRepository.findById(saveId).get(); // id를 통해 yoonseo 객체를 찾는다
        Assertions.assertEquals(member.getName(), findMember.getName()); // 같은지 확인
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        // Given
        Member member1 = new Member();
        member1.setName("sprin");

        Member member2 = new Member();
        member2.setName("sprin");

        // When
        memberService.join(member1);

        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); //예외가 발생해야 함

        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
