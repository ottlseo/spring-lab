package ewhaian.goods.repository;

import ewhaian.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, String> {
    // save()는 JPARepository 상속받았기 때문에 오버라이딩
    Optional<Goods> findByOrderId(String orderId); // 고유번호로 주문 조회
    //List<Goods> find
}
