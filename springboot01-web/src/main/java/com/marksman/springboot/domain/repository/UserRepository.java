package com.marksman.springboot.domain.repository;

import com.marksman.springboot.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author weilb
 * @date 2018/8/19
 * @description
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);

    List<User> findByEmailLike(String email);

    @Override
    Page<User> findAll(Pageable pageable);

    List<User> findTop2ByPassWord(String password, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int modifyByIdAndUserName(String userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(Long id);

    @Transactional
    @Query("select u from User u where u.email = ?1")
    List<User> findByEmail(String email);


}
