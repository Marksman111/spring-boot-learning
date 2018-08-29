package com.marksman.springboot08shiro.repository;


import com.marksman.springboot08shiro.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    UserInfo findByUsername(String username);
}
