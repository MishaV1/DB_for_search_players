package com.example.db_for_players.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> allEvents(){
        return repository.findAll();
    }

    public Event get_by_id(long id){
        return repository.findById(id).get();
    }
}
