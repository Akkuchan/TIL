package com.example.springsecuritytest.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    private String email;
    private String roles; //User, Manager, Admin
    private String provider;
    private String providerId;

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Builder
    public Member(String username, String email, String roles, String provider, String providerId) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.provider = provider;
        this.providerId = providerId;
    }
}
