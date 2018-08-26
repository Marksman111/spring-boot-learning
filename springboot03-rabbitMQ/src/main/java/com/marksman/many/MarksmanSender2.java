package com.marksman.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Component
public class MarksmanSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(int i){
        String context = "spring boot marksman queue"+" ****** "+i;
        System.out.println("Sender2: "+context);
        this.rabbitTemplate.convertAndSend("marksman",context);
    }
}
