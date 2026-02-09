package com.ehdnd.spring_basic.order;

import com.ehdnd.spring_basic.discount.DiscountPolicy;
import com.ehdnd.spring_basic.member.Member;
import com.ehdnd.spring_basic.member.MemberRepository;
import com.ehdnd.spring_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

}
