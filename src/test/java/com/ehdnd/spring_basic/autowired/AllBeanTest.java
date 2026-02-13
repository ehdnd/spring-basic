package com.ehdnd.spring_basic.autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ehdnd.spring_basic.AutoAppConfig;
import com.ehdnd.spring_basic.discount.DiscountPolicy;
import com.ehdnd.spring_basic.member.Grade;
import com.ehdnd.spring_basic.member.Member;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class AllBeanTest {

  @Test
  void findAllBean() {
    ApplicationContext ac = new AnnotationConfigReactiveWebApplicationContext(AutoAppConfig.class,
        DiscountService.class);

    DiscountService discountService = ac.getBean(DiscountService.class);
    Member member = new Member(1L, "userA", Grade.VIP);

    int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
    assertThat(discountService).isInstanceOf(DiscountService.class);
    assertThat(discountPrice).isEqualTo(1000);

    int rateDiscountPrice = discountService.discount(member, 20000,
        "rateDiscountPolicy");
    assertThat(rateDiscountPrice).isEqualTo(2000);
  }

  static class DiscountService {

    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;

    // 생성자 파라미터를 Map/List<DiscountPolicy>로 선언하면,
    // 스프링이 DiscountPolicy의 모든 구현 빈을 찾아 컬렉션으로 주입한다.
    // 다만, 다형성을 적극 활용하는 비즈니스 로직은, 수동 등록을 고민하자.
    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
      this.policyMap = policyMap;
      this.policies = policies;
      System.out.println("policyMap = " + policyMap);
      System.out.println("policies = " + policies);
    }

    public int discount(Member member, int price, String discountCode) {
      DiscountPolicy discountPolicy = policyMap.get(discountCode);
      return discountPolicy.discount(member, price);
    }
  }

}
