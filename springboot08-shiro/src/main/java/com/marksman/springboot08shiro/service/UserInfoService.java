package com.marksman.springboot08shiro.service;

import com.marksman.springboot08shiro.entity.UserInfo;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
public interface UserInfoService {

    UserInfo findByUsername(String username);
}
