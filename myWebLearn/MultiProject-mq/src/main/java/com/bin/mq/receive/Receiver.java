package com.bin.mq.receive;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Receiver
 * @Description: 当队 lister 监听到队列接收到 消息执行
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("testQueue"))
public class Receiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("消费者接收到的消息是：" + message);
    }
}
