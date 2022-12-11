package com.example.rabbitmqmessaging.consumer;


import com.example.rabbitmqmessaging.RabbitMqConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReceiveMessageController {
    private final RabbitTemplate rabbitTemplate;

    public ReceiveMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/receivemohamed")
    public String getMessage(){
        String message = rabbitTemplate.receive("mohamedQueue", 1000).toString();
        return message;
    }
    @GetMapping("/receiveahmed")
    public String getMessage2(){
        String message = rabbitTemplate.receive("ahmedQueue", 1000).toString();
        return message;
    }

}
