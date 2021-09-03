package com.example.project.order;

import com.example.project.discount.DiscountPolicy;
import com.example.project.discount.FixDiscountPolicy;
import com.example.project.discount.RateDiscountPolicy;
import com.example.project.member.Member;
import com.example.project.member.MemberRepository;
import com.example.project.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     *
     * 밑에 있는 방법처럼 하면 결국 OrderService는 DiscountPolicy 인터페이스와 FixDiscountPolicy 클래스 둘다 의존하게 된다.
     *  우리는 DiscountPolicy 인터페이스에만 의존하게끔 하는게 목표이다.
     */
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
