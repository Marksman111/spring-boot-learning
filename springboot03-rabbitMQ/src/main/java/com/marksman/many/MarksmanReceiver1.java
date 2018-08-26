package com.marksman.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Component
@RabbitListener(queues = "marksman")
public class MarksmanReceiver1 {

    @RabbitHandler
    public void process(String marksman){
        System.out.println("Receiver1: "+marksman);
    }
}
