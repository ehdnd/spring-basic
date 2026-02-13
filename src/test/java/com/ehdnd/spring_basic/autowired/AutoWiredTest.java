package com.ehdnd.spring_basic.autowired;

import com.ehdnd.spring_basic.member.Member;
import org.springframework.lang.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class AutoWiredTest {


  @Test
  void AutoWiredOption() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }

  @Component
  static class TestBean {

    // Member는 스프링 빈이 아니다. 빈에 존재하지 않으면 건너뛴다. 호출 / 에러 없음.
    // 호출 안됨
    @Autowired(required = false)
    public void setNoBean1(Member member) {
      System.out.println("setNoBean1 = " + member);
    }

    // null 호출
    @Autowired
    public void setNoBean2(@Nullable Member member) {
      System.out.println("setNoBean2 = " + member);
    }

    // Optional.empty 호출
    @Autowired(required = false)
    public void setNoBean3(Optional<Member> member) {
      System.out.println("setNoBean3 = " + member);
    }
  }
}
