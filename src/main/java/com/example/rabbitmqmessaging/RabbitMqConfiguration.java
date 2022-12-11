package com.example.rabbitmqmessaging;

import com.example.rabbitmqmessaging.consumer.ReceiveMessageHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {




    @Bean
    Queue createQueue() {
        return new Queue("mohamedQueue", true, false, false);
    }
    @Bean
    Queue createAnotherQueue() {
        return new Queue("ahmedQueue", true, false, false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("amrExchange");
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(createQueue()).to(exchange()).with("all.mohamed");
    }

    @Bean
    Binding binding1(){
        return BindingBuilder.bind(createQueue()).to(exchange()).with("all");
    }
    @Bean
    Binding binding2(){
        return BindingBuilder.bind(createAnotherQueue()).to(exchange()).with("all.ahmed");
    }

    @Bean
    Binding binding3(){
        return BindingBuilder.bind(createAnotherQueue()).to(exchange()).with("all");
    }

  /*  @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory
            , MessageListenerAdapter messageListenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(messageListenerAdapter);
        return container;
    }


    @Bean
    MessageListenerAdapter listenerAdapter(ReceiveMessageHandler handler){
        return new MessageListenerAdapter(handler, "handleMessage");
    }*/


}
