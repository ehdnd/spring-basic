package com.ehdnd.spring_basic.web;

import com.ehdnd.spring_basic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final ObjectProvider<MyLogger> myLoggerProvider;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    String requestURL = request.getRequestURL().toString();
    MyLogger myLogger = myLoggerProvider.getObject(); // 이 때 최초로 만들어진다.
    myLogger.setRequestURL(requestURL); // 스프링 인터셉터를 사용하는 것이 좋다.

    myLogger.log("controller test");
    logDemoService.logic("testId");

    return "OK";
  }

}
