package com.example.SpringSecurityPractice.service;

import com.example.SpringSecurityPractice.config.auth.PrincipalDetail;
import com.example.SpringSecurityPractice.model.User;
import com.example.SpringSecurityPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//SecurityConfig 에서 loginProcessingUrl("/login")이라고 코드를 작성했다.
// /login 요청이 오면 요쳥이 오면 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername()가 실행된다.
@Service//(IoC)
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) //해당 username은  loginForm에서 Http바디로 들어오는 값의 이름과 동일해야 한다.
            throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username);
        if(userEntity!=null) return new PrincipalDetail(userEntity);
            return null;
     }
}
