package com.example.SpringSecurityPractice.config;



import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset("UTF-8");// 내가 만드는 뷰의 인코딩방법
        resolver.setContentType("text/html; charset=UTF-8");//던지는 데이터는 html파일이고 UTF-8이다
        resolver.setPrefix("classpath:/templates/");//classpath는 우리 프로젝트까지의 경로이다.
        resolver.setSuffix(".html");//.html파일을 만들더라도 머스테치가 알아서 인식을 하게된다.

        registry.viewResolver(resolver);
    }
}
