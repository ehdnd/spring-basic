package com.ehdnd.spring_basic.scan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ehdnd.spring_basic.AutoAppConfig;
import com.ehdnd.spring_basic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

}
