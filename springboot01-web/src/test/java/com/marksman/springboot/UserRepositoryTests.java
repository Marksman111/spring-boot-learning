package com.marksman.springboot;

import com.marksman.springboot.domain.entity.User;
import com.marksman.springboot.domain.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author weilb
 * @date 2018/8/19
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa", "123456", "aa@126.com", "a",formattedDate));
        userRepository.save(new User("bb", "123456", "bb@126.com", "b",formattedDate));
        userRepository.save(new User("cc", "123456", "cc@126.com", "c",formattedDate));
        userRepository.save(new User("dd", "123456", "dd@126.com", "d",formattedDate));
        userRepository.save(new User("ee", "123456", "ee@126.com", "e",formattedDate));
        userRepository.save(new User("ff", "123456", "ff@126.com", "f",formattedDate));
        userRepository.save(new User("gg", "123456", "gg@126.com", "g",formattedDate));
        userRepository.save(new User("hh", "123456", "hh@126.com", "h",formattedDate));
        userRepository.save(new User("ii", "123456", "ii@126.com", "i",formattedDate));

        //Assert.assertEquals(3,userRepository.findAll().size());
        //Assert.assertEquals("b",userRepository.findByUserNameOrEmail("bb","bb@126.com").getNickName());
        //userRepository.delete(userRepository.findByUserName("aa"));
    }
}
