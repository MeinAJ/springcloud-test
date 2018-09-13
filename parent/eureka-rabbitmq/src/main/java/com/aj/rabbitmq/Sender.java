package com.aj.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 *
 * 发送者
 *
 */
@Repository(value = "sender")
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public String send(String name){

        String context  = "hello"+name+" ,now the time is"+new Date();
        this.rabbitTemplate.convertAndSend("hello",context);
        return context;
    }
}
