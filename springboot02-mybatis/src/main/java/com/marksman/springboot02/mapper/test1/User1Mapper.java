package com.marksman.springboot02.mapper.test1;

import com.marksman.springboot02.entity.User;

import java.util.List;

/**
 * @author weilb
 * @date 2018/8/24
 * @description
 */
public interface User1Mapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
