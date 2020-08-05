package com.alex.prediction.models;

import javax.persistence.*;

@Entity
@Table(name = "userassists")
public class UserAssist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public UserAssist(){}

    public UserAssist(int position, String nameOfPlayer, String season, User user) {
        this.position = position;
        this.nameOfPlayer = nameOfPlayer;
        this.season = season;
        this.user = user;
    }

    public int getPosition() {
        return position;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public String getSeason() {
        return season;
    }
}
