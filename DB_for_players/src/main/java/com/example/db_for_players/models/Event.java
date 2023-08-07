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

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player_id;

    @Column(name = "game")
    private String game;

    @Column(name = "description")
    private String description;

    @Column(name = "criteries")
    private String criterias;
}
