package com.ehdnd.spring_basic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // HTTP 요청 당 각각 구분된다.
public class MyLogger {

  private String uuid;
  @Setter
  private String requestURL;

  public void log(String message) {
    System.out.println("[" + uuid + "] " + "[" + requestURL + "] " + message);
  }

  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println("[" + uuid + "] request scope bean create: " + this);
  }

  @PreDestroy
  public void destory() {
    System.out.println("[" + uuid + "] request scope bean close: " + this);
  }
}
