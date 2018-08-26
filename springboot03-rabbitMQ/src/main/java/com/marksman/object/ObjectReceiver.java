package com.marksman.object;

import com.marksman.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.println("Receiver object: "+user );
    }
}
