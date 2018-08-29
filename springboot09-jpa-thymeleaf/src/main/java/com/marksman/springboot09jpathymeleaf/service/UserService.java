package com.marksman.springboot09jpathymeleaf.service;

import com.marksman.springboot09jpathymeleaf.entity.User;

import java.util.List;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
public interface UserService {

    List<User> getUserList();

    User findUserById(Long id);

    void save(User user);

    void edit(User user);

    void delete(long id);
}