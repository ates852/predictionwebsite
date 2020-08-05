package com.alex.prediction.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "cleansheet")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CleanSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ident;
    private int clean_sheets_overall;
    private String known_as;
    private String position;
    private String season;

    public int getClean_sheets_overall() {
        return clean_sheets_overall;
    }

    public void setClean_sheets_overall(int clean_sheets_overall) {
        this.clean_sheets_overall = clean_sheets_overall;
    }

    public String getKnown_as() {
        return known_as;
    }

    public void setKnown_as(String known_as) {
        this.known_as = known_as;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
