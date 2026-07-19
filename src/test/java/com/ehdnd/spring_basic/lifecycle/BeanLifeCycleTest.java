package com.ehdnd.spring_basic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  // 스프링 컨테이너 생성 - 스프링 빈 생성 - 의존관계 주입 - 초기화 콜백 - 사용 - 소멸전 콜백- 스프링 종료

  @Test
  public void lifeCycleTest() {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
        LifeCycleConfig.class);
    NetworkClient client = ac.getBean(NetworkClient.class);
    ac.close();
  }

  @Configuration
  static class LifeCycleConfig {

    @Bean
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient(); // 객체 생성 (파라미터)
      networkClient.setUrl("http://dev.dev"); // 초기화 (무거운) - 두 작업을 분리
      return networkClient;
    }
  }

}
