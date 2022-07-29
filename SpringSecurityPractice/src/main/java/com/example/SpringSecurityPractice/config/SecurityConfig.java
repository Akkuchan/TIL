package com.example.SpringSecurityPractice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity//스프링 시큐리티 필터(SecurityConfig)가 스프링 필터체인에 등록이 된다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {//사용자별로 부여된 인가에 따라서 접근을 제한하기 위해 사용

    @Bean//@Bean 애너테이션으로 해당 메서드의 리턴값을 IoC로 등록해준다.
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()//권한이 있는 사용자만 요청을 받아줄 것이다.(아래에 자세한 내용을 작성)
                .antMatchers("/user/**").authenticated()// 인증만 되면 접근 가능한 페이지
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")// user, admin, manager 처럼 권한없는 페이지로 갈 때는 login으로 보냈는데 이것을 설정해주는 코드
                .loginProcessingUrl("/login")// login 주소가 호출되면 시큐리티가 낚아 대신 로그인을 진행한다. -> /login 매서드가 없어도 됨
                .defaultSuccessUrl("/");//로그인 성공시 우선 원래 가려고 하던 특정 페이지를 리턴하고 목적 페이지가 없으면 defailt로 /로 이동한다.


    }
}

