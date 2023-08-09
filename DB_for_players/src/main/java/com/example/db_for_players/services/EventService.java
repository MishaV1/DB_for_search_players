package com.example.db_for_players.services;

import com.example.db_for_players.models.Event;
import com.example.db_for_players.models.Player;
import com.example.db_for_players.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> get_all_events(){
        return repository.findAll();
    }

    public Event get_by_id(long id){
        return repository.findById(id).get();
    }

    public void delete_by_id(long id){
        repository.deleteById(id);
    }

    public void put_new(Event new_event){
        repository.save(new_event);
    }
}
