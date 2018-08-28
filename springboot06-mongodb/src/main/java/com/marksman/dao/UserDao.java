package com.marksman.dao;

import com.marksman.entity.UserEntity;

/**
 * @author weilb
 * @date 2018/8/28
 * @description
 */
public interface UserDao {

    void saveUser(UserEntity userEntity);

    UserEntity findUserByUserName(String userName);

    void updateUser(UserEntity userEntity);

    void deleteUserById(Long id);
}
