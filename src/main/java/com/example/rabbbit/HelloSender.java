package com.example.rabbbit;

import com.example.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ProjectName: springboot-rabbitmq
 * @Package: com.example.rabbbit
 * @ClassName: HelloSender
 * @Description: 发送者
 * @Author: Xiao Nong
 * @Version: 1.0
 */
@Component
@RestController
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send(User user) {
        user.setPassword("111111");
        user.setUsername("我告诉对方公司电话");

        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
        return context+user+user.getUsername();
    }
}
