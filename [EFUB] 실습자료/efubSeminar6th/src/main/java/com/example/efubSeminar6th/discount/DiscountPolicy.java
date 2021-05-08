package com.example.efubSeminar6th.discount;

import com.example.efubSeminar6th.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
