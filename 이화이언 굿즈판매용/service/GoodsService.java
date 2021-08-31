package ewhaian.goods.service;

import ewhaian.goods.domain.Goods;
import ewhaian.goods.dto.GoodsDto;
import ewhaian.goods.repository.GoodsRepository;import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;


    // 고유번호 랜덤으로 생성하는 함수
    public String generateId(){
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) { // 고유번호 6자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }
    // 주문 내용 db 저장
    public String save(GoodsDto goodsDto){
        goodsDto.setOrderId(generateId());
        return goodsRepository.save(Goods.builder()
                .name(goodsDto.getName())
                .tel(goodsDto.getTel())
                .addrCode(goodsDto.getAddrCode())
                .address(goodsDto.getAddress())
                .msg(goodsDto.getMsg())
                .totalPrice(goodsDto.getTotalPrice())
                .build())       //저장하고
                .getOrderId();  //고유번호 반환
    }
    // 주문번호로 주문 조회
    public Optional<Goods> loadOrderByOrderId(String orderId) { // throws NotFoundException
        return goodsRepository.findByOrderId(orderId);
        //.orElseThrow(() -> new NotFoundException((userName)));
    }


}