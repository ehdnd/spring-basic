package com.ehdnd.spring_basic.order;

import com.ehdnd.spring_basic.member.Grade;
import com.ehdnd.spring_basic.member.Member;
import com.ehdnd.spring_basic.member.MemberService;
import com.ehdnd.spring_basic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  void createOrder() {
    // given
    Long memberId = 1L;
    Member member = new Member(memberId, "userA", Grade.VIP);
    memberService.join(member);

    // when
    Order order = orderService.createOrder(memberId, "itemA", 10000);

    // then
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
