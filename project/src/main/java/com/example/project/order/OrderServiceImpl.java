package com.example.project.order;

import com.example.project.discount.DiscountPolicy;
import com.example.project.discount.FixDiscountPolicy;
import com.example.project.discount.RateDiscountPolicy;
import com.example.project.member.Member;
import com.example.project.member.MemberRepository;
import com.example.project.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 생성자 주입 방법
 * 1. 생성자를 사용
 * 2. setter를 사용
 * 3. 필드 주입
 * 4. 일반메서드 주입 (의존관계 자동 주입 : Autowired는 스프링 컨테이너가 관리하는 스프링 빈이어야 한다. 스프링 빈이 아닌 클래스에서 @Autowired를 적용해도
 *      아무 소용이 없다.)
 */
@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //생성자가 단 한개만 있다면 @Autowired를 생략해도 된다.
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
    //Test용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
