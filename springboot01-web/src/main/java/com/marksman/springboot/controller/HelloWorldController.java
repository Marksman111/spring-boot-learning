package com.marksman.springboot.controller;

import com.marksman.springboot.domain.entity.User;
import com.marksman.springboot.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @author weilb
 * @date 2018/8/19
 * @description
 */

@RestController
public class HelloWorldController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setRegTime( new Date()+"");
        user.setId(1L);
        user.setUserName("小花");
        user.setPassWord("123456");
        user.setEmail("xiaohua@199.com");
        user.setNickName("你怕是活在梦里哦!!");
        return user;
    }

    @RequestMapping("/getUser1")
    @Cacheable(value = "user-key")
    public User getUser1(){
        User user = userRepository.findByUserName("bb");
        System.out.println("--------");
        return user;
    }

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
