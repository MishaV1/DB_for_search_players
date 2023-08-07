package com.example.db_for_players;

import com.example.db_for_players.models.Event;
import com.example.db_for_players.models.Player;
import com.example.db_for_players.services.EventService;
import com.example.db_for_players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/{id}")
    Event findByid(@PathVariable("id") long id){
        return eventService.get_by_id(id);
    }

    @GetMapping("/all")
    List<Event> findAll(){
        return eventService.allEvents();
    }

}
