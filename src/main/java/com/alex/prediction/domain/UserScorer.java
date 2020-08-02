package com.alex.prediction.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userscorers")
public class UserScorer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "position")
    private int position;
    @Column(name = "name_of_player")
    private String nameOfPlayer;
    @Column(name = "season")
    private String season;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public UserScorer() {
    }

    public UserScorer(int position, String nameOfPlayer, String season, User user) {
        this.position = position;
        this.nameOfPlayer = nameOfPlayer;
        this.user = user;
        this.season = season;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }


    public int getPosition() {
        return position;
    }


    public String getSeason() {
        return season;
    }
}
