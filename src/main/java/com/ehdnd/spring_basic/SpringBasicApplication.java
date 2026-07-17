package com.ehdnd.spring_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 이 안에 `@ComponentScan`
public class SpringBasicApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBasicApplication.class, args);
  }

}
