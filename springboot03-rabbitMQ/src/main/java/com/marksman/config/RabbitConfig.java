package com.marksman.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue marksmanQueue(){
        return new Queue("marksman");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("object");
    }
}
