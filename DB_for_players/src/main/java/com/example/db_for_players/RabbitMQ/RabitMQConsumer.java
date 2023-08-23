package com.example.db_for_players.RabbitMQ;

import com.example.db_for_players.models.Event;
import com.example.db_for_players.models.Player;
import com.example.db_for_players.services.EventService;
import com.example.db_for_players.services.PlayerService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabitMQConsumer {

    @Autowired
    EventService eventService;

    @Autowired
    PlayerService playerService;

    @RabbitListener(queues = "Player")
    public void processMyQueue_for_Players(String message){
        System.out.println(message);
        playerService.put_new(new Player(message));
    }

    @RabbitListener(queues = "Event")
    public void processMyQueue_for_Events(String message){
        System.out.println(message);
        eventService.put_new(new Event(message));
    }
}
