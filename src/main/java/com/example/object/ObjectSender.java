package com.example.object;

import com.example.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springboot-rabbitmq
 * @Package: com.example.object
 * @ClassName: ObjectSender
 * @Description: 对象发送者
 * @Author: Xiao Nong
 * @Version: 1.0
 */


@Component
@RestController
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/send2")
    public String  send(User user) {
        user.setPassword("111111");
        user.setUsername("我告诉对方公司电话");
        user.setId(9567856);
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
        return user.toString();
    }
}
