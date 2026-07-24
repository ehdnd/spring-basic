package com.ehdnd.spring_basic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import jakarta.inject.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        PrototypeBean.class);

    PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
    PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

    prototypeBean1.addCount();
    assertThat(prototypeBean1.getCount()).isEqualTo(1);

    prototypeBean2.addCount();
    assertThat(prototypeBean2.getCount()).isEqualTo(1);
  }

  @Test
  void singletonClientUsePrototype() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,
        PrototypeBean.class);

    ClientBean clientBean1 = ac.getBean(ClientBean.class);

    int count1 = clientBean1.logic();
    assertThat(count1).isEqualTo(1);

    int count2 = clientBean1.logic();
    assertThat(count2).isEqualTo(1);
  }

  @Scope("singleton")
  static class ClientBean {

    @Autowired
    private Provider<PrototypeBean> prototypeBeanProvider;

    public int logic() {
      PrototypeBean prototypeBean = prototypeBeanProvider.get();
      prototypeBean.addCount();
      return prototypeBean.getCount();
    }
  }

  @Scope("prototype")
  static class PrototypeBean {

    private int count = 0;

    public void addCount() {
      ++count;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean init" + this);
    }

    @PreDestroy // 호출 안되긴 한다.
    public void destroy() {
      System.out.println("PrototypeBean destroy");
    }

  }
}
