package com.marksman;

import com.marksman.entity.User;
import com.marksman.hello.HelloSender;
import com.marksman.many.MarksmanSender1;
import com.marksman.many.MarksmanSender2;
import com.marksman.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private MarksmanSender1 marksmanSender1;

    @Autowired
    private MarksmanSender2 marksmanSender2;

    @Autowired
    private ObjectSender objectSender;

    @Test
    public void hello(){
        helloSender.send();
    }

    @Test
    public void oneToMany(){
        for (int i = 0; i < 100; i++){
            marksmanSender1.send(i);
        }
    }

    @Test
    public void manyToMany(){
        for (int i = 0; i < 100; i++){
            marksmanSender1.send(i);
            marksmanSender2.sender(i);
        }
    }

    @Test
    public void object(){
        User user = new User("marksman","123456");
        objectSender.send(user);
    }
}
