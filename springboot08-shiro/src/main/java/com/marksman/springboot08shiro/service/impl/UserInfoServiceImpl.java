package com.marksman.springboot08shiro.service.impl;

import com.marksman.springboot08shiro.entity.UserInfo;
import com.marksman.springboot08shiro.repository.UserInfoRepository;
import com.marksman.springboot08shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
