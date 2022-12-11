package com.example.rabbitmqmessaging.producer;


import com.example.rabbitmqmessaging.RabbitMqConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String theMessage){
        rabbitTemplate.convertAndSend("amrExchange",
                "group1.all", theMessage);
        return "We have sent a message! :" + theMessage;
    }
}