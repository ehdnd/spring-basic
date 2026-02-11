package com.ehdnd.spring_basic;

import com.ehdnd.spring_basic.discount.DiscountPolicy;
import com.ehdnd.spring_basic.discount.FixDiscountPolicy;
import com.ehdnd.spring_basic.discount.RateDiscountPolicy;
import com.ehdnd.spring_basic.member.MemberRepository;
import com.ehdnd.spring_basic.member.MemberService;
import com.ehdnd.spring_basic.member.MemberServiceImpl;
import com.ehdnd.spring_basic.member.MemoryMemberRepository;
import com.ehdnd.spring_basic.order.OrderService;
import com.ehdnd.spring_basic.order.OrderServiceImpl;
// import 주의하자.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  // @Bean memberService -> new MemoryMemberRepository()
  // @Bean orderService -> new MemoryMemberRepository()

  @Bean
  public MemberService memberService() {
    System.out.println("call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    System.out.println("call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }

}
