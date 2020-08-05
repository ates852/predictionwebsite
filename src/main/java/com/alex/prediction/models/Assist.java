package com.alex.prediction.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ident;
    private String known_as;
    private int assists_overall;
    private String season;

    public Assist() {
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getAssists_overall() {
        return assists_overall;
    }

    public void setAssists_overall(int assists_overall) {
        this.assists_overall = assists_overall;
    }

    public String getKnown_as() {
        return known_as;
    }

    public void setKnown_as(String know_as) {
        this.known_as = know_as;
    }
}
