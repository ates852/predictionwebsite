package com.alex.prediction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ident;
    private int goalsFor;
    private int lost;
    private int won;
    private int playedGames;
    private int position;

    @Embedded
    private TeamNameInfo team;

    private int draw;
    private int goalsAgainst;
    private int goalDifference;
    private int points;

    public Team() {
    }

    public String getTeamName() {
        return team.getName();
    }
}
