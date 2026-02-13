package com.ehdnd.spring_basic.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ehdnd.spring_basic.discount.FixDiscountPolicy;
import com.ehdnd.spring_basic.member.Grade;
import com.ehdnd.spring_basic.member.Member;
import com.ehdnd.spring_basic.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

  @Test
  void createOrder() {
    // given
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    memberRepository.save(new Member(1L, "memberA", Grade.VIP));
    // when
    OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "itemA", 10000);
    // then
    assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

}
