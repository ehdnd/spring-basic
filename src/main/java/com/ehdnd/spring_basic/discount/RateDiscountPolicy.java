package com.ehdnd.spring_basic.discount;

import com.ehdnd.spring_basic.member.Grade;
import com.ehdnd.spring_basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

  private int discountPercent = 10; // 10%

  // cmd(ctrl) + shift + t: TEST 만들어준다
  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP){
      return price * discountPercent / 100;
    } else {
      return 0;
    }
  }
}
