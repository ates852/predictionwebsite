package com.alex.prediction.models;

import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userteams")
@SelectBeforeUpdate
public class UserTeam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "position")
    private int position;
    @Column(name = "name_of_team")
    private String nameOfTeam;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"),name = "user_id")
    private User user;

    public UserTeam() {
    }

    public UserTeam(int position, String nameOfTeam, User user) {
        this.position = position;
        this.nameOfTeam = nameOfTeam;
        this.user = user;
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
