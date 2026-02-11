package com.ehdnd.spring_basic.xml;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ehdnd.spring_basic.AppConfig;
import com.ehdnd.spring_basic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

  @Test
  void xmlAppContext() {
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

}
