package com.bin.config.rabbitmq.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Configuration
public class QueueTotal {

    @Bean
    public Queue testQueue(){
        return new Queue("testQueue");
    }
}
