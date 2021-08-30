package ewhaian.goods.controller;

import ewhaian.goods.domain.Goods;
import ewhaian.goods.dto.GoodsDto;
import ewhaian.goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GoodsController {
    private final GoodsService goodsService;

    // 주문번호(orderId) 입력하면 배송 조회하는 api
    @RequestMapping(value = "/lookup/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public Goods getOrderInfo(@PathVariable("orderId") String orderId){
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
