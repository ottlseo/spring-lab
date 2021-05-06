package ottl.hijava.repository;
import org.springframework.stereotype.Repository;
import ottl.hijava.domain.Member;
import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository { //인터페이스를 상속

    private static Map<Long, Member> store = new HashMap<>(); // id-name 저장할 해시맵 객체 store
    private static long sequence = 0L; //임의의 숫자(id값으로 사용)

    @Override
    public Member save(Member member){
        member.setId(++sequence); //store에 넣기 전에 member에 등록
        store.put(member.getId(),member); // id, member(name) 값을 맵에 등록
        return member; //저장한 후, 객체 반환
    }

    @Override
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(store.get(id));
        // 원래 return store.get(id);이지만, null일 경우에 대비해 Optional로 감싸주는 게 요즘 추세
    }
    @Override
    public Optional<Member> findByName(String name){
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //같은 경우
                .findAny();
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //모든 value를 출력
    }

    public void clearStore(){
        store.clear();
    }
}
