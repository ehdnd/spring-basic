package com.ehdnd.spring_basic.singleton;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean("statefulService",
        StatefulService.class);
    StatefulService statefulService2 = ac.getBean("statefulService",
        StatefulService.class);

    // Thread A: A사용자 10000원 주문
    statefulService1.order("userA", 10000);
    // Thread B: B사용자 20000원 주문
    statefulService2.order("userB", 20000);

    // Thrsad A: A사용자 주문 금액 조회
    int price = statefulService1.getPrice();
    // Thread A는 10000원을 기대했지만, 20000원 출력
    System.out.println("price = " + price);

    assertThat(statefulService1.getPrice()).isEqualTo(20000);
  }

  static class TestConfig {

    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }


}
