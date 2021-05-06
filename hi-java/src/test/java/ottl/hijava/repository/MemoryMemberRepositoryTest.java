package ottl.hijava.repository;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ottl.hijava.domain.Member;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  /// -- 중요!! 테스트가 서로 의존관계 갖지 않도록 설계--
    public void afterEach(){ //객체 만들고 테스트 끝날 때마다 clear
        repository.clearStore();
    }

    @Test
    public void save(){ // save()가 잘 동작하는지 테스트해보자
        Member member = new Member();
        member.setName("spring"); //member 객체의 이름은 spring
        repository.save(member); //repository에 member를 저장

        Member result = repository.findById(member.getId()).get(); // DB에서 꺼낸 Id가 같은지 본다

        //System.out.println("result = "+(result==member)); //이렇게 해도 되지만, Assertions 활용
        Assertions.assertEquals(member, result); //실행 시 같다고 뜸
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }
    // 테스트케이스에서 옳지 않으면 뒤로 넘어갈 수 없게 막음!! 테스트 케이스의 역할

    @Test
    public void findByName(){ //findByName이 잘 동작하는지 테스트
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2); //repo에 객체 저장

        Member result = repository.findByName("spring1").get(); //repo에서 spring1로 객체 찾아와

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1); //비교
    }
    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
        // result라는 리스트의 사이즈가 2인지 확인--
    }
}
