package com.alex.prediction.models;

import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_assists")
@SelectBeforeUpdate
public class UserAssist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "position")
    private int position;
    @Column(name = "name_of_player")
    private String nameOfPlayer;
    @Column(name = "season")
    private String season;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"), name = "user_id")
    private User user;

    public UserAssist(){}

    public UserAssist(int position, String nameOfPlayer, String season, User user) {
        this.position = position;
        this.nameOfPlayer = nameOfPlayer;
        this.season = season;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
