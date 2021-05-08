package com.example.efubSeminar6th.discount;

import com.example.efubSeminar6th.member.Grade;
import com.example.efubSeminar6th.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; //10% 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
