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
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "userA", Grade.VIP);
    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);

  }

}
