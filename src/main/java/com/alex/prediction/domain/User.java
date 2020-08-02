package com.alex.prediction.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    @Column(name = "standings_id")
    private int standingsId;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<UserTeam> usersTeam;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<UserScorer> usersScorer;

    public User(){
    }

    public User(String name,String password,int standingsId){
        this.name=name;
        this.password = password;
        this.standingsId = standingsId;
    }
}
