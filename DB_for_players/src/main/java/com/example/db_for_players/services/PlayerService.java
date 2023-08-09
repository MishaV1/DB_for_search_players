package com.example.db_for_players.services;

import com.example.db_for_players.models.Player;
import com.example.db_for_players.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerService;

    public List<Player> get_all_players(){
        return playerService.findAll();
    }

    public Player get_by_id(long id){
        return playerService.findById(id).get();
    }

    public void delete_by_id(long id){
        playerService.deleteById(id);
    }

    public void put_new(Player new_player){
        playerService.save(new_player);
    }
}
