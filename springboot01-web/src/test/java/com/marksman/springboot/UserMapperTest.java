package com.marksman.springboot;

import com.marksman.springboot.domain.entity.User;
import com.marksman.springboot.mapper.UserMapper;
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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
      * @description user_Sex值无效，不正常啊 exception is java.sql.SQLException:
      *                                      Incorrect integer value: 'MALE' for column 'user_sex'
      * @params []
      * @return void
      * @author weilb
      * @date 2018/8/24
      */

    @Test
    public void testInsert(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userMapper.insert(new User("jj", "123456", "jj@126.com", "j",formattedDate));
    }

    @Test
    public void testFindAll(){
        List<User> list = userMapper.getAll();
        System.out.println("-------"+list.size());
    }

    @Test
    public void testUpdate(){
        User user = userMapper.getOne(4L);
        System.out.println(user.toString());
        user.setNickName("王大锤");
        user.setUserName("大锤");
        userMapper.update(user);
        Assert.assertTrue("王大锤".equals(userMapper.getOne(4L).getNickName()));
    }
}
