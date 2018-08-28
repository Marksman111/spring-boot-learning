package com.marksman;

import com.marksman.dao.UserDao;
import com.marksman.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarksmanApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSaveUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(2L);
        userEntity.setUseName("小明");
        userEntity.setPassWord("123456");
        userDao.saveUser(userEntity);
    }

}
