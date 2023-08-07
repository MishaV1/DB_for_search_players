package com.example.db_for_players;

import com.example.db_for_players.models.Player;
import com.example.db_for_players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    Player findByid(@PathVariable("id") long id){
        return playerService.get_by_id(id);
    }

    @GetMapping("/all")
    List<Player> findAll(){
        return playerService.get_all_players();
    }
}
