package com.aj.rabbitmq.controller;

import com.aj.rabbitmq.Sender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/test")
public class RabbitController {

    @Resource(name = "sender")
    private Sender sender;

    @RequestMapping(value = "/send",method = RequestMethod.GET,produces = "application/json;charset=utf-8",headers = "accept=*/*")
    public String sendMessage(HttpServletRequest request){
        String send = sender.send("this is the first test for rabbitmq");
        System.out.println("sendMessage=" + send);
        return send;
    }
}
