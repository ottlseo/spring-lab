package ewhaian.goods.dto;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
public class GoodsDto {
    private String orderId; //자동생성되는 주문번호. unique한 값
    private String name; //구매자 이름
    private String tel;  //01011111111
//  private String password; //주문 조회를 위해 비밀번호 설정-> 이름과 비번 입력하면 주문 조회되게

    private Long addrCode; //우편번호
    private String address; //주소(동호수까지 상세히. 책임지지 않습니다)
    private String msg; //배송 요청사항

    private Long totalPrice; //프론트에서 자동으로 계산됨

    public GoodsDto(String name, String tel, Long addrCode, String address, String msg, Long totalPrice) {
        this.name = name;
        this.tel = tel;
        this.addrCode = addrCode;
        this.address = address;
        this.msg = msg;
        this.totalPrice = totalPrice;
    }
}
