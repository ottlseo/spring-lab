package ewhaian.goods.controller;

import ewhaian.goods.domain.Goods;
import ewhaian.goods.dto.GoodsDto;
import ewhaian.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class GoodsController {

    @Autowired
    private final GoodsService goodsService;

    // 주문번호(orderId) 입력하면 배송 조회하는 api
    @RequestMapping(value = "/lookup/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Goods> getOrderInfo(@PathVariable("orderId") String orderId){
        return goodsService.loadOrderByOrderId(orderId);
    }

    // 프론트에서 정보 받을시 db에 저장하는 api
    //@RequestMapping(value = "/order", method = RequestMethod.POST)
    //@ResponseBody
    @PostMapping(value = "/order")
    public String order(@RequestBody GoodsDto goodsDto){
        return goodsService.save(goodsDto); //프론트의 정보 받아서 db에 save
        // 어떻게 받나? 프론트에서 dto로 어떻게 주고 있는거지
    }

}
/* 에러 내용: 401  -> 이유: SpringSecurity가 아직 남아잇음
{
    "timestamp": "2021-08-31T06:51:14.345+00:00",
    "status": 401,
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/lookup/0"
}
 */
/* POST 데이터 예시
{"orderId":"0","name":"김윤서","tel":"01095923360","addrCode":14245,"address":"광명어쩌구","msg":"null","totalPrice":12000}
 */