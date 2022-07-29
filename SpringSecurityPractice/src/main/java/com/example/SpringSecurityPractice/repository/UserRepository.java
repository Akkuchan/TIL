package com.example.SpringSecurityPractice.repository;

import com.example.SpringSecurityPractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//CRUD 함수를 JpaRepository가 들고 있음
//@Repository라는 어노테이션이 없어도 IoC가 된다. JpaRepository를 상속했기 때문에
public interface UserRepository extends JpaRepository<User, Integer> {
    //findBy규칙 -> Username문법: 이것을 query method라고 부른다.
    //select * from user where username = !
    public User findByUsername(String username);

    //select * from user where Email = email
    //public User findbyEmail(String email)
}
