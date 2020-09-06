package com.alex.prediction.controller;

import com.alex.prediction.models.Team;
import com.alex.prediction.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<Team> list(@RequestParam String season) {
        return teamService.getList();
    }

}
