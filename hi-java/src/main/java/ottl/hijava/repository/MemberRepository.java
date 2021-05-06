package ottl.hijava.repository;
import ottl.hijava.domain.Member; //domain의 member 클래스 import

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /* interface 니까 상속받는 클래스에 대한 정의 포함해야함 */

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
