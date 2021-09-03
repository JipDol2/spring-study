package com.example.project;

import com.example.project.member.Grade;
import com.example.project.member.Member;
import com.example.project.member.MemberService;
import com.example.project.AppConfig;
import com.example.project.order.Order;
import com.example.project.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = "+order);
    }
}
