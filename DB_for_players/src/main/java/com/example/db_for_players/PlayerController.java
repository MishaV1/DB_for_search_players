package com.example.db_for_players;

import com.example.db_for_players.models.Event;
import com.example.db_for_players.models.Player;
import com.example.db_for_players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<String> creatingNewPlayer(Player player){
        playerService.put_new(player);
        return new ResponseEntity<>("Player was added ", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletingPlayer(long id){
        try{
            playerService.delete_by_id(id);
            return new ResponseEntity<>("Player was deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Cannot delete player", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
