package com.example.efubSeminar6th;

import com.example.efubSeminar6th.member.Grade;
import com.example.efubSeminar6th.member.Member;
import com.example.efubSeminar6th.member.MemberService;
import com.example.efubSeminar6th.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());

        System.out.println("find Member = " + findMember.getName());

    }
}