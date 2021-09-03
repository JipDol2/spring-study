package com.example.project.discount;

import com.example.project.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
