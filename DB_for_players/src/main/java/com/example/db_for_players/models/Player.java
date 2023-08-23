package com.example.db_for_players.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "discorde")
    private String discorde;

    @Column(name = "game")
    private String game;

    @Column(name = "description")
    private String description;

    public Player(){

    }
    public Player(String message){
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
        this.age = Integer.valueOf(results[2]);
        this.discorde = results[3];
        this.game = results[4];
        this.description = results[5];
    }
}
