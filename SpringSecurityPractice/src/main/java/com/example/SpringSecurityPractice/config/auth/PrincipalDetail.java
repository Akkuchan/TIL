package com.example.SpringSecurityPractice.config.auth;


import com.example.SpringSecurityPractice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//시큐리티가 /login 주소요청이 오면 이를 낚아채서 로그인을 진행시킨다
// 로그인 진행이 완료되면 시큐리티 session을 만들어준다.(Security ContextHolder, 서버의 세션 공간 안에 한 자리 차지하는 별도 세션 공간)
// 이 session 안에는 Authentication 타입의 객체가 멤버로 존재하고
// Authentication 내부에 User 정보가 존재해야 한다.(Authentication가 인증, 인가를 위한 객체니까 그 대상인 사용자 정보 즉 User 객체가 있는 것
// User 객체의 타입은 UserDetails 라는 이름의 클래스 타입을 되어있다.
// Security Session ⊃ Authentication ⊃ UserDetails(PrincipalDetail-구현체) ⊃ User
public class PrincipalDetail implements UserDetails {

    private User user;// 컴포지션?????

    public PrincipalDetail(User user) {
        this.user = user;
    }
    // 해당 유저의 권한을 리턴하는 매서드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //아래 4가지 메서드들은 사용자 계정의 활성화 여부를 반환한다. 예로 1년 동안 접속 기록없으면 비활성화로 바꾼다. 등등
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
