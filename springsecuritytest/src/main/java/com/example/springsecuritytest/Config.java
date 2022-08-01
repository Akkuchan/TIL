package com.example.springsecuritytest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {//아까 만든 필터1을 적용하기 위한 설정 파일

    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegister(){
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>(new FirstFilter());
        registrationBean.setOrder(1);// 필터의 순서를 정할 수 있다.
        return registrationBean;

    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilterRegistrater(){
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>(new SecondFilter());
        registrationBean.setOrder(2);
        return registrationBean;

    }

}
