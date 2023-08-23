package com.example.db_for_players.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "player_id")
    private long player_id;

    @Column(name = "game")
    private String game;

    @Column(name = "description")
    private String description;

    @Column(name = "criteries")
    private String criterias;

    public Event(){

    }
    public Event(String message) {
        boolean flag = false;
        String res = "";
        for(int i = 0; i < message.length(); i++){
            if(flag){
                res += message.charAt(i);
            }
            if(message.charAt(i) == '='){
                flag = true;
            }
            if(message.charAt(i) == ',' || message.charAt(i) == ')'){
                flag = false;
                res += " ";
            }
        }
        String[] results = res.split(" ");

        this.id = Long.valueOf(results[0]);
        this.name = results[1];
        this.player_id = Long.valueOf(results[2]);
        this.game = results[3];
        this.description = results[4];
        this.criterias = results[5];
    }
}
