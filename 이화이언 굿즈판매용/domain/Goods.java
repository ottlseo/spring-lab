package ewhaian.goods.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="GOODS") // GOODS 테이블과 매핑
@Getter
@Setter
public class Goods {

    @Id
    @Column(name = "order_id", unique = true)
    private String orderId;

    @Column(name = "name")
    private String name; //구매자 이름
    @Column(name = "tel")
    private String tel;  //01011111111

    @Column(name = "addr_code")
    private Long addrCode; //우편번호
    @Column(name = "address")
    private String address; //주소
    @Column(name = "msg")
    private String msg; //배송 요청사항
    @Column(name = "total_price")
    private Long totalPrice; //프론트에서 자동으로 계산되게 하기

    @Builder
    public Goods(
            String name,
            String tel,
            Long addrCode,
            String address,
            String msg,
            Long totalPrice) {
        this.name = name;
        this.tel = tel;
        this.addrCode = addrCode;
        this.address = address;
        this.msg = msg;
        this.totalPrice = totalPrice;
    }
}
