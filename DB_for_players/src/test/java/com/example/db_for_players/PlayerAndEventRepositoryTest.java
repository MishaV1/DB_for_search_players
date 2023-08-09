package com.example.db_for_players;


import com.example.db_for_players.models.Event;
import com.example.db_for_players.models.Player;
import com.example.db_for_players.repositories.EventRepository;
import com.example.db_for_players.repositories.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerAndEventRepositoryTest {



    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EventRepository eventRepository;

    @Test
    void shouldReturnPlayer(){
        Player player = new Player();
        player.setId(2);
        player.setName("Dota");
        player.setAge(12);
        player.setGame("Dota 2");
        player.setDescription("genius");


        playerRepository.save(player);

        Event event = new Event();
        event.setName("емае");
        event.setId(5);
        event.setGame("Dota 2");
        event.setCriterias("age >5");
        event.setDescription("dfesfes");
        event.setPlayer_id(player.getId());


        Player new_player = playerRepository.findById(Long.valueOf(2)).get();


        assert(new_player.getName().equals(player.getName()));
    }

    @Test
    void shouldreturnPlayerfromEvent(){
        Player player = new Player();
        player.setId(2);
        player.setName("Dota");
        player.setAge(12);
        player.setGame("Dota 2");
        player.setDescription("genius");


        playerRepository.save(player);

        Event event = new Event();
        event.setName("емае");
        event.setId(5);
        event.setGame("Dota 2");
        event.setCriterias("age >5");
        event.setDescription("dfesfes");
        event.setPlayer_id(player.getId());
        eventRepository.save(event);

        Event new_event = eventRepository.findById(Long.valueOf(5)).get();

        assert(new_event.getPlayer_id() == player.getId());
    }

}
