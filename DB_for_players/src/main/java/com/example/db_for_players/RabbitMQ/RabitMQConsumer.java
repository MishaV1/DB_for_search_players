package com.example.db_for_players.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabitMQConsumer {
    @RabbitListener(queues = "Player")
    public void processMyQueue_for_Players(String message){
        System.out.println(message);
    }

    @RabbitListener(queues = "Event")
    public void processMyQueue_for_Events(String message){
        System.out.println(message);
    }
}
