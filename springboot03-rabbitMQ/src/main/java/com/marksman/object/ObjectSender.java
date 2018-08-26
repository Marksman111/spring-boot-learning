package com.marksman.object;

import com.marksman.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user){
        System.out.println("Sender object: "+user.toString());
        this.rabbitTemplate.convertAndSend("object",user);
    }
}
