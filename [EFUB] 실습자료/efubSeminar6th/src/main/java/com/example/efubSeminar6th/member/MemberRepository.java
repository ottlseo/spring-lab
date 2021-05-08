package com.example.efubSeminar6th.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}