package com.example.project;

import com.example.project.discount.FixDiscountPolicy;
import com.example.project.member.MemberService;
import com.example.project.member.MemberServiceImpl;
import com.example.project.member.MemoryMemberRepository;
import com.example.project.order.OrderService;
import com.example.project.order.OrderServiceImpl;

/**
 * 추상화를 위해 의존성을 AppConfig에서 넘겨주고
 * 받는 족에서 생성자를 통해 의존성을 받는다. => 생성자를 통한 의존성 주입(Dependency Injection)
 */
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
