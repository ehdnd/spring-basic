package com.ehdnd.spring_basic.web;

import com.ehdnd.spring_basic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  private final MyLogger myLogger;

  public void logic(String id) {
    myLogger.log("service id = " + id);
  }
}
