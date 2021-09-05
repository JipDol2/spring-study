package com.example.project;

import com.example.project.discount.DiscountPolicy;
import com.example.project.discount.FixDiscountPolicy;
import com.example.project.discount.RateDiscountPolicy;
import com.example.project.member.MemberService;
import com.example.project.member.MemberServiceImpl;
import com.example.project.member.MemoryMemberRepository;
import com.example.project.order.OrderService;
import com.example.project.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 추상화를 위해 의존성을 AppConfig에서 넘겨주고
 * 받는 족에서 생성자를 통해 의존성을 받는다. => 생성자를 통한 의존성 주입(Dependency Injection)
 */

@Configuration
public class AppConfig {
    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
}
