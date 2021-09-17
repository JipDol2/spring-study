package com.example.project;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//ComponentScan은 @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
@ComponentScan(
        basePackages = "com.example.project.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
