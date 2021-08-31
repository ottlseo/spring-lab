package ewhaian.goods.repository;
import ewhaian.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface GoodsRepository extends JpaRepository<Goods, String> {
    Optional<Goods> findByOrderId(String orderId);
}
// JpaRepository를 상속받아준다
// name으로 회원 조회하기 위한 함수도 생성