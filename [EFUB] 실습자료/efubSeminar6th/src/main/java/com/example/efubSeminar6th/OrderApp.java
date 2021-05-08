package com.example.efubSeminar6th;

import com.example.efubSeminar6th.member.Grade;
import com.example.efubSeminar6th.member.Member;
import com.example.efubSeminar6th.member.MemberService;
import com.example.efubSeminar6th.member.MemberServiceImpl;
import com.example.efubSeminar6th.order.Order;
import com.example.efubSeminar6th.order.OrderService;
import com.example.efubSeminar6th.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
