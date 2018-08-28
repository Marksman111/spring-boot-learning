package com.marksman.springboot;

import com.marksman.springboot.domain.entity.User;
import com.marksman.springboot.mapper.UserMapper1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author weilb
 * @date 2018/8/24
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapper1Test {

    @Autowired
    private UserMapper1 userMapper;

    @Test
    public void testInsert(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userMapper.insert(new User("tt", "123456", "tt@126.com", "t",formattedDate));
    }

    @Test
    public void testFindAll(){
        List<User> list = userMapper.getAll();
        System.out.println("-------"+list.size());
    }

    @Test
    public void testUpdate(){
        User user = userMapper.getOne(11L);
        System.out.println(user.toString());
        user.setNickName("乔杉");
        user.setUserName("大宝剑");
        userMapper.update(user);
        Assert.assertTrue("乔杉".equals(userMapper.getOne(11L).getNickName()));
    }

    @Test
    public void testDelete(){
        userMapper.delete(1L);
    }
}
