package com.example.SpringSecurityPractice.controller;

import com.example.SpringSecurityPractice.model.User;
import com.example.SpringSecurityPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//View를 리턴하겠다.
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;//비밀번호 암호화를 위해 DI

    @GetMapping({"","/"})
    public String index(){
        //머스테치 기본폴더 src/main/resources/
        //뷰리졸버 설정 : templates(prefix), .mustache(suffix)(의존성 설정을 해주면 default로 설정이 된다. 즉 생략가능한 설정이다)
        return "index";// src/main/resources/templates/index.mustache를 찾는다.
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
            return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println(user.toString()+"123123123");
        user.setRole("Role_User");
        String rawPassword =user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        userRepository.save(user);//이를 통해 회원가입을
        // 통한 DB에 회원정보가 전달되지만 비밀번호 1234같은 상태로는 시큐리티로 로그인이 하면 안된다.
        // 암호화가 필요하다. 이를 위해서 BCryptPasswordEncoder 객체를 DI받아 활용하여 암호화를 진행한다.
        return "redirect:/loginForm";
    }

//    @GetMapping("/login")
//    public @ResponseBody String login(){
//        return "login";
//    }

}
