package ewhacodic.demo.dao;

import ewhacodic.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO { // dao ==interface (함수 정의)
    User save(User user); //회원가입
    //Optional<User> findBySeq_number(long seq_number);  //번호로 찾기
    //Optional<User> findByName(String name); //이름으로 찾기
    //Optional<User> findById(String id); //아이디로 찾기
    List<User> findAll(); // 유저 리스트 조회
}
