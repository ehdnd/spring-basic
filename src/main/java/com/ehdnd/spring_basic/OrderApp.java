package com.ehdnd.spring_basic;

import com.ehdnd.spring_basic.member.Grade;
import com.ehdnd.spring_basic.member.Member;
import com.ehdnd.spring_basic.member.MemberService;
import com.ehdnd.spring_basic.member.MemberServiceImpl;
import com.ehdnd.spring_basic.order.Order;
import com.ehdnd.spring_basic.order.OrderService;
import com.ehdnd.spring_basic.order.OrderServiceImpl;

public class OrderApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "userA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);

  }

}
