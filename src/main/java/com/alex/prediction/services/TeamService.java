package com.alex.prediction.services;

import com.alex.prediction.models.Team;
import com.alex.prediction.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Iterable<Team> list() {
        return teamRepository.findAll();
    }

    public List<Team> getList() {
        return teamRepository.findAll();
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }


    public void save(List<Team> teams) {
        teamRepository.deleteAll();
        teamRepository.saveAll(teams);
    }
}
