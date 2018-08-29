package com.marksman.springboot09jpathymeleaf.repository;

import com.marksman.springboot09jpathymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(long id);

}