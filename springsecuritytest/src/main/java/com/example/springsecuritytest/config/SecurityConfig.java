package com.example.springsecuritytest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity//스프링 세큐리티 필터가 스프링 필터페인에 등록된다.
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

//    @Autowired // 비밀번호 암호화를 위한 DI
//    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();//form 태그로만 요청이 가능해지고 postman 등의 요청이 불가능하게 된다.그래서 위에 csrf를 disable해준다.
        http.headers().frameOptions().disable();//h2와 연결할 때 필요

        http.authorizeRequests()//요청에 의한 보안 검사
                .antMatchers("/user/**").authenticated()
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest()
                    .permitAll()
                        .and()
                            .formLogin()
                                .loginPage("/login");//위 3줄의 코드는 권한없는 페이지로 접속할 경우에 login 페이지로 이동하도록 하는 코드이다.
        return http.build();
    }

    @Bean // 추가
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
