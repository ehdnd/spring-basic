package com.ehdnd.spring_basic;

import com.ehdnd.spring_basic.discount.FixDiscountPolicy;
import com.ehdnd.spring_basic.member.MemberService;
import com.ehdnd.spring_basic.member.MemberServiceImpl;
import com.ehdnd.spring_basic.member.MemoryMemberRepository;
import com.ehdnd.spring_basic.order.OrderService;
import com.ehdnd.spring_basic.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }

}
