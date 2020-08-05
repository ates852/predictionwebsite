package com.alex.prediction.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scorer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ident;
    private int goals_overall;
    private String known_as;
    private String season;

    public Scorer() {
    }

    public int getGoals_overall() {
        return goals_overall;
    }

    public void setGoals_overall(int goals_overall) {
        this.goals_overall = goals_overall;
    }

    public String getKnown_as() {
        return known_as;
    }

    public void setKnown_as(String known_as) {
        this.known_as = known_as;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}