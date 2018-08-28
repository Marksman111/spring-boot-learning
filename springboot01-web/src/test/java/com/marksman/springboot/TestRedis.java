package com.marksman.springboot;

import com.marksman.springboot.domain.entity.User;
import com.marksman.springboot.util.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author weilb
 * @date 2018/8/23
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws InterruptedException {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("dd", "dd123456", "dd@126.com", "d",formattedDate);
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set("com.marksman",user);
        operations.set("com.marksman.m",user,1,TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("com.marksman.m");
        if (exists){
            System.out.println("########exists is true");
        } else {
            System.out.println("########exists is false");
        }
        Assert.assertEquals("dd",operations.get("com.marksman.m").getUserName());
    }
}
