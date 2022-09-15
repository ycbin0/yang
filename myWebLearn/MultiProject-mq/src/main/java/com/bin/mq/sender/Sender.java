package com.bin.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Sender
 * @Description: RabbitMQ 发送着
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送给测试队列
     */
    public void send(){
        String newTimeContext = "现在的时间是" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        this.amqpTemplate.convertAndSend("testQueue", newTimeContext);
    }
}
