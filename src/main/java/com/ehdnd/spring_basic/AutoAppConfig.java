package com.ehdnd.spring_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class AutoAppConfig {
  // 기존의 AppConfig 와는 다르게 @Bean 으로 등록한 클래스가 없다.
}
