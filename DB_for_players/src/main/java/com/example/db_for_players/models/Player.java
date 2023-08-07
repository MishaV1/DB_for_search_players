package com.example.db_for_players.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "player")
public class Player {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "game")
    private String game;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "event")
    private List<Event> events;
}
