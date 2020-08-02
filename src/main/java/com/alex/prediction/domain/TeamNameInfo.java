package com.alex.prediction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class TeamNameInfo {
    private String crestUrl;
    private String name;
    private int id;

    public TeamNameInfo(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
