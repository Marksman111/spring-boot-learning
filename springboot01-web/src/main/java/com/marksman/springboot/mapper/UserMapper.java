package com.marksman.springboot.mapper;

import com.marksman.springboot.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author weilb
 * @date 2018/8/23
 * @description
 */
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "nickName",column = "nick_name")
    })
    User getOne(Long id);

    @Insert("insert into user (email, nick_name, pass_word, reg_time, user_name) " +
            "values (#{email}, #{nickName}, #{passWord}, #{regTime}, #{userName})")
    void insert(User user);

    @Update("update user set user_name = #{userName},nick_name = #{nickName} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(Long id);
}