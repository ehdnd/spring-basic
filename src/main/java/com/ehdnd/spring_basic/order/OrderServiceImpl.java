package com.ehdnd.spring_basic.order;

import com.ehdnd.spring_basic.discount.DiscountPolicy;
import com.ehdnd.spring_basic.member.Member;
import com.ehdnd.spring_basic.member.MemberRepository;
import com.ehdnd.spring_basic.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

  // 한 번 설정하면 바뀌지 않는, 불변 필수 의존관계 - 생성자 주입 (setter 메서드 만들면 안되겠지.)
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  // 생성자가 하나만 있으면 @Autowired 생략이 가능하다.
  @Autowired
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

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }

}
