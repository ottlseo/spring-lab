package efub.ebs.DAO;

import efub.ebs.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDAO {
    List<UserDTO> select() throws Exception;

    // 인터페이스이므로 함수이름만 정의
    // UserDTO 객체를 여러개 리턴함
}
