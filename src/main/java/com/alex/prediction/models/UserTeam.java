package com.alex.prediction.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userteams")
public class UserTeam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private int position;
    @Column(name = "name_of_team")
    private String nameOfTeam;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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
}
