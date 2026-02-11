package com.ehdnd.spring_basic.singleton;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ehdnd.spring_basic.AppConfig;
import com.ehdnd.spring_basic.member.MemberRepository;
import com.ehdnd.spring_basic.member.MemberServiceImpl;
import com.ehdnd.spring_basic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService",
        MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService",
        OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository",
        MemberRepository.class);

    // 모두 같은 인스턴스를 참고하고 있다.
    System.out.println("memberService -> memberRepository = " +
        memberService.getMemberRepository());
    System.out.println("orderService -> memberRepository  = " +
        orderService.getMemberRepository());
    System.out.println("memberRepository = " + memberRepository);

    // 모두 같은 인스턴스를 참고하고 있다.
    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
  }

  @Test
  void configurationDeep() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // AppConfig도 스프링 빈으로 등록된다.
    AppConfig bean = ac.getBean(AppConfig.class);

    System.out.println("bean = " + bean.getClass());
    // bean = class com.ehdnd.spring_basic.AppConfig$$SpringCGLIB$$0
  }

}
