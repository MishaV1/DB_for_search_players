package com.example.db_for_players;

import com.example.db_for_players.models.Event;
import com.example.db_for_players.models.Player;
import com.example.db_for_players.services.EventService;
import com.example.db_for_players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return eventService.get_all_events();
    }

    @PostMapping("/create")
    public ResponseEntity<String> creatingNewEvent(Event event){
        eventService.put_new(event);
        return new ResponseEntity<>("Event was added ", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletingEvent(long id){
        try{
            eventService.delete_by_id(id);
            return new ResponseEntity<>("Event was deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Cannot delete event", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
