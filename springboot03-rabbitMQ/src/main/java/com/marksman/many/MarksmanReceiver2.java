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
@RabbitListener
public class MarksmanReceiver2 {

    @RabbitHandler
    public void process(String marksman){
        System.out.println("Receiver2: "+marksman);
    }

}
