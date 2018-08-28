package com.marksman.springboot.mapper;

import com.marksman.springboot.domain.entity.User;

import java.util.List;

/**
 * @author weilb
 * @date 2018/8/24
 * @description
 */
public interface UserMapper1 {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
