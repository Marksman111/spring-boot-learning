package com.marksman.springboot02.controller;

import com.marksman.springboot02.entity.User;
import com.marksman.springboot02.mapper.test1.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weilb
 * @date 2018/8/24
 * @description
 */
@RestController
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users = user1Mapper.getAll();
        return users;
    }

    @RequestMapping("/add")
    public void save(User user){
        user1Mapper.insert(user);
    }

    @RequestMapping("/update")
    public void update(User user){
        user1Mapper.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        user1Mapper.delete(id);
    }
}
